package model;



import lombok.*;

import java.util.List;

/**
 * @author kumar on 29/08/18
 * @project X-search
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImdbData {
  private String title;
  private String year;
  private String rated;
  private String released;
  private String runtime;
  private String genre;
  private String director;
  private String writer;
  private String actors;
  private String plot;
  private String language;
  private String country;
  private String awards;
  private String poster;
  private List<Rating> ratings = null;
  private String metascore;
  private String imdbRating;
  private String imdbVotes;
  private String imdbID;
  private String type;
  private String dVD;
  private String boxOffice;
  private String production;
  private String website;
  private String response;

    public String getDirector() {
        return director;
    }
}
