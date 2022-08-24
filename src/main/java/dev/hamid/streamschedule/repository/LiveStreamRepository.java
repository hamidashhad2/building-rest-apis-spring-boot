package dev.hamid.streamschedule.repository;

import dev.hamid.streamschedule.exception.LiveStreamNotFoundException;
import dev.hamid.streamschedule.model.LiveStream;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LiveStreamRepository {
    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository() {
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Building REST APIs with Spring Boot",
                """
                           Spring Boot is very convenient to use when building REST APIs; it allows you to start with minimal configurations.
                           But there’s always room for trouble to creep in. Join us for the next IntelliJ IDEA Live Stream to learn how best to avoid this trouble in
                           developing your project. During the February show, Dan Vega will show us how to make sure we’re following good practices when working with Spring Initializr.
                        """,
                "https://www.twtich.tv/danvega",
                LocalDateTime.of(2022, 8, 16, 11, 0),
                LocalDateTime.of(2022, 8, 16, 12, 0)
        ));
    }

    public List<LiveStream> findAll() {
        return streams;
    }

    public LiveStream findById(String id) throws LiveStreamNotFoundException {
        return streams.stream().filter(liveStream -> liveStream.id().equals(id)).findFirst().orElseThrow(()-> new LiveStreamNotFoundException("Stream Object Not found"));
    }

    public LiveStream create(LiveStream stream) {
        streams.add(stream);
        return stream;
    }

    public void update(String id, LiveStream stream) {
        LiveStream object = streams.stream().filter(str -> str.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Stream not found"));
        int i = streams.indexOf(object);
        streams.set(i, stream);
    }

    public void delete(String id) {
        streams.removeIf(stream -> stream.id().equals(id));
    }
}
