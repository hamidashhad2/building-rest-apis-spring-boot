package dev.hamid.streamschedule.model;

import java.time.LocalDateTime;

public record LiveStream( String id,
         String title,
         String description,
         String url,
         LocalDateTime startDate,
         LocalDateTime endDate) {

    //canonical constructor
    /*public LiveStream(String id, String title, String description, String url, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.startDate = startDate;
        this.endDate = endDate;
    }*/

    // compact constructor
    /*public LiveStream {
        if(id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }*/
}
