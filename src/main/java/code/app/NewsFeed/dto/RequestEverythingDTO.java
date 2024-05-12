package code.app.NewsFeed.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestEverythingDTO {
    @JsonProperty("filter_by")
    private String filterBy;
    @JsonProperty("from_time")
    private LocalDate fromTime;
    @JsonProperty("sort_by")
    private String sortBy;
    @JsonProperty("base_url")
    private String base_url;

    public String getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(String filterBy) {
        this.filterBy = filterBy;
    }

    public LocalDate getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalDate fromTime) {
        this.fromTime = fromTime;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }
}
