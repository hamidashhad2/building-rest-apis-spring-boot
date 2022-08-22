package dev.hamid.streamschedule.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class LiveStreamTest {

    @Test
    void create_new_mutable_live_stream() {
        MutableLiveStream stream = new MutableLiveStream();
        stream.setId(UUID.randomUUID().toString());
        stream.setTitle("Building REST APIs with Spring Boot");
        stream.setDescription("""
                    we are developing this program to write and test rest apis in java spring.
                """);
        stream.setUrl("https://www.github.com/hamidashhad2");
        stream.setStartDate(LocalDateTime.of(2022,8, 22,10,51,11));
        stream.setStartDate(LocalDateTime.of(2022,8, 23,10,51,11));

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring Boot", stream.getTitle(), "Title is incorrect");
    }

    @Test
    void create_new_immutable_live_stream() {
        ImmutableLiveStream stream = new ImmutableLiveStream(UUID.randomUUID().toString(), "Building REST APIs with Spring Boot", """
                    we are developing this program to write and test rest apis in java spring.
                """, "https://www.github.com/hamidashhad2"
                ,LocalDateTime.of(2022,8, 22,10,51,11)
                ,LocalDateTime.of(2022,8, 23,10,51,11));

        assertNotNull(stream);
        assertEquals("Building REST APIs with Spring Boot", stream.getTitle(), "Title is incorrect");


    }


}
