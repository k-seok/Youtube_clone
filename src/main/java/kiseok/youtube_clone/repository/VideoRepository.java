package kiseok.youtube_clone.repository;

import kiseok.youtube_clone.domain.Member;
import kiseok.youtube_clone.domain.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class VideoRepository {
    private final EntityManager em;

    public void save(Video video) {
        em.persist(video);
    }

    public Video findOne(Long id) {
        return em.find(Video.class, id);
    }

    /** 선택지 2개.
    1. repository 에서 에러 처리
     2. 서비스에서 에러 처리.
     어떤게 나을까?
    **/
    public void delete(Video video){
        em.remove(video);
    }

    public List<Video> findAll() {
        return em.createQuery("select v from Video v", Video.class).getResultList();
    }

}
