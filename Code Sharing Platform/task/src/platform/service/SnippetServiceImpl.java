package platform.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import platform.dto.SnippetDto;
import platform.mapper.SnippetMapper;
import platform.model.Snippet;
import platform.persistence.SnippetRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SnippetServiceImpl implements SnippetService{

    private final SnippetMapper snippetMapper;
    private final SnippetRepository snippetRepository;

    @Autowired
    public SnippetServiceImpl(SnippetRepository repository, SnippetMapper snippetMapper) {
        this.snippetRepository = repository;
        this.snippetMapper = snippetMapper;
    }

    @Override
    @Transactional
    public List<SnippetDto> findLatest() {
        List<Snippet> list = snippetRepository.findAllWithoutAnyRestrictionOrderByDateDescLimitTen();
        return snippetMapper.snippetsToListSnippetDto(list);
    }

    @Override
    @Transactional
    public Map<String, String> saveCodeSnippetDto(SnippetDto snippetDto) {

        Snippet snippet = snippetMapper.snippetDtoToSnippet(snippetDto);
        snippet = snippetRepository.save(snippet);

        return Map.of("id", snippet.getId());
    }

    @Override
    @Transactional
    public Optional<Snippet> findById(String id) {

        Optional<Snippet> opt = snippetRepository.findById(id);

        long remainingTime;
        if (opt.isPresent()) {
            Snippet snippet = opt.get();

            if (snippet.getViews() >= 0 && snippet.getTime() >= 0) {

                remainingTime = snippet.getTime() - ChronoUnit.SECONDS.between(snippet.getDate(), LocalDateTime.now());
                snippet.updateTime(remainingTime <= 0 ? 0 : remainingTime);

                if (snippet.isSecret() && snippet.getTime() == 0 && snippet.getViews() == 0) {
                    return Optional.empty();
                }

                snippet.decrementViews();

                this.saveSnippet(snippet);

                return Optional.of(snippet);
            }
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Snippet> findSecretSnippetById(String uuid) {
        return snippetRepository.findSecretSnippetById(uuid);
    }

    @Override
    @Transactional
    public synchronized void decrementViews(String id) {
        this.snippetRepository.decrementViews(id);
    }

    @Override
    @Transactional
    public void updateTime(long time, String id) {
        this.snippetRepository.updateTime(time <= 0 ? 0 : time, id);
    }

    @Override
    @Transactional
    public void deleteById(String uuid) {
        this.snippetRepository.deleteById(uuid);
    }

    @Override
    @Transactional
    public void saveSnippet(Snippet snippet) {
        this.snippetRepository.save(snippet);
    }

    @Override
    public Optional<Snippet> findByIdIgnoreRestrictions(String uuid) {
        return snippetRepository.findById(uuid);
    }
}
