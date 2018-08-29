package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONObjects {

    public static String sbReport = new String("<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<title>Table V04</title>\n" +
            "<meta charset=\"UTF-8\">\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=2\">\n" +
            "<!--===============================================================================================-->\n" +
            "<script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/2.6.9/angular.min.js\"></script>\n" +
            "<!--===============================================================================================-->\n" +
            "<!--===============================================================================================-->\n" +
            "<script type=\"text/javascript\" src=\"js/data.js\"></script>\n" +
            "<!--===============================================================================================-->\n" +
            "<!-- <link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/> -->\n" +
            "<!--===============================================================================================-->\n" +
            "<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\"> -->\n" +
            "<!--===============================================================================================-->\n" +
            "<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\"> -->\n" +
            "<!--===============================================================================================-->\n" +
            "<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\"> -->\n" +
            "<!--===============================================================================================-->\n" +
            "<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\"> -->\n" +
            "<!--===============================================================================================-->\n" +
            "<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/perfect-scrollbar/perfect-scrollbar.css\"> -->\n" +
            "<!--===============================================================================================-->\n" +
            "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\">\n" +
            "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\n" +
            "<!--===============================================================================================-->\n" +
            "</head>\n" +
            "<body ng-app=\"myApp\" ng-controller=\"myCtrl\">\n" +
            "<center><img src=\"https://www.tiket.com/assets_version/cardamom/dist/images/tiketcom.png\" width=\"220\" height=\"60\"></center>\n" +
            "<div class=\"limiter\">\n" +
            "<div><h3></h3></div>\n" +
            "<div class=\"container-table100\">\n" +
            "<div class=\"wrap-table100\" ng-repeat=\"y in records\">\n" +
            "<div class=\"table100-heading\">\n" +
            "<h3> Test Case Name : Movies</h3>\n" +
            "</div>\n" +
            "<div class=\"table100 ver1 m-b-110\">\n" +
            "<div class=\"table100-head\">\n" +
            "<table>\n" +
            "<thead>\n" +
            "<tr class=\"row100 head\">\n" +
            "<th class=\"cell100 column1\">Movie ID</th>\n" +
            "<th class=\"cell100 column2\">Movie Name</th>\n" +
            "<th class=\"cell100 column3\">Wikipedia URL</th>\n" +
            "<th class=\"cell100 column4\">Snapshot of Wiki</th>\n" +
            "<th class=\"cell100 column5\">Wiki Directors</th>\n" +
            "<th class=\"cell100 column6\">Imdb URL</th>\n" +
            "<th class=\"cell100 column7\">Snapshot of IMDB</th>\n" +
            "<th class=\"cell100 column8\">Wiki IMDB Directors</th>\n" +
            "<th class=\"cell100 column9\">Name diff;erences</th>\n" +
            "</tr>\n" +
            "</thead>\n" +
            "</table>\n" +
            "</div>\n" +
            "<div class=\"table100-body js-pscroll\">\n" +
            "<table>\n" +
            "<tbody>\n" +
            "<tr>\n" +
            "<td></td>\n" +
            "<td></td>\n" +
            "<td></td>\n" +
            "<td></td>\n" +
            "<td></td>\n" +
            "<td></td>\n" +
            "<td></td>\n" +
            "<td></td>\n" +
            "<td></td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2</td>\n" +
            "<td>Movie 1 name</td>\n" +
            "<td>Movie 1 wiki url</td>\n" +
            "<td>Movie 1 wiki snap</td>\n" +
            "<td>Movie 1 wiki Directors</td>\n" +
            "<td>Movie 1 imdb url</td>\n" +
            "<td>Movie 1 imdb snap</td>\n" +
            "<td>Movie 1 imdb director</td>\n" +
            "<td>Movie 1 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2</td>\n" +
            "<td>Movie 2 name</td>\n" +
            "<td>Movie 2 wiki url</td>\n" +
            "<td>Movie 2 wiki snap</td>\n" +
            "<td>Movie 2 wiki Directors</td>\n" +
            "<td>Movie 2 imdb url</td>\n" +
            "<td>Movie 2 imdb snap</td>\n" +
            "<td>Movie 2 imdb director</td>\n" +
            "<td>Movie 2 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2</td>\n" +
            "<td>Movie 3 name</td>\n" +
            "<td>Movie 3 wiki url</td>\n" +
            "<td>Movie 3 wiki snap</td>\n" +
            "<td>Movie 3 wiki Directors</td>\n" +
            "<td>Movie 3 imdb url</td>\n" +
            "<td>Movie 3 imdb snap</td>\n" +
            "<td>Movie 3 imdb director</td>\n" +
            "<td>Movie 3 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2</td>\n" +
            "<td>Movie 4 name</td>\n" +
            "<td>Movie 4 wiki url</td>\n" +
            "<td>Movie 4 wiki snap</td>\n" +
            "<td>Movie 4 wiki Directors</td>\n" +
            "<td>Movie 4 imdb url</td>\n" +
            "<td>Movie 4 imdb snap</td>\n" +
            "<td>Movie 4 imdb director</td>\n" +
            "<td>Movie 4 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4</td>\n" +
            "<td>Movie 5 name</td>\n" +
            "<td>Movie 5 wiki url</td>\n" +
            "<td>Movie 5 wiki snap</td>\n" +
            "<td>Movie 5 wiki Directors</td>\n" +
            "<td>Movie 5 imdb url</td>\n" +
            "<td>Movie 5 imdb snap</td>\n" +
            "<td>Movie 5 imdb director</td>\n" +
            "<td>Movie 5 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4</td>\n" +
            "<td>Movie 6 name</td>\n" +
            "<td>Movie 6 wiki url</td>\n" +
            "<td>Movie 6 wiki snap</td>\n" +
            "<td>Movie 6 wiki Directors</td>\n" +
            "<td>Movie 6 imdb url</td>\n" +
            "<td>Movie 6 imdb snap</td>\n" +
            "<td>Movie 6 imdb director</td>\n" +
            "<td>Movie 6 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4</td>\n" +
            "<td>Movie 7 name</td>\n" +
            "<td>Movie 7 wiki url</td>\n" +
            "<td>Movie 7 wiki snap</td>\n" +
            "<td>Movie 7 wiki Directors</td>\n" +
            "<td>Movie 7 imdb url</td>\n" +
            "<td>Movie 7 imdb snap</td>\n" +
            "<td>Movie 7 imdb director</td>\n" +
            "<td>Movie 7 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4</td>\n" +
            "<td>Movie 8 name</td>\n" +
            "<td>Movie 8 wiki url</td>\n" +
            "<td>Movie 8 wiki snap</td>\n" +
            "<td>Movie 8 wiki Directors</td>\n" +
            "<td>Movie 8 imdb url</td>\n" +
            "<td>Movie 8 imdb snap</td>\n" +
            "<td>Movie 8 imdb director</td>\n" +
            "<td>Movie 8 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4</td>\n" +
            "<td>Movie 9 name</td>\n" +
            "<td>Movie 9 wiki url</td>\n" +
            "<td>Movie 9 wiki snap</td>\n" +
            "<td>Movie 9 wiki Directors</td>\n" +
            "<td>Movie 9 imdb url</td>\n" +
            "<td>Movie 9 imdb snap</td>\n" +
            "<td>Movie 9 imdb director</td>\n" +
            "<td>Movie 9 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4</td>\n" +
            "<td>Movie 10 name</td>\n" +
            "<td>Movie 10 wiki url</td>\n" +
            "<td>Movie 10 wiki snap</td>\n" +
            "<td>Movie 10 wiki Directors</td>\n" +
            "<td>Movie 10 imdb url</td>\n" +
            "<td>Movie 10 imdb snap</td>\n" +
            "<td>Movie 10 imdb director</td>\n" +
            "<td>Movie 10 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2</td>\n" +
            "<td>Movie 11 name</td>\n" +
            "<td>Movie 11 wiki url</td>\n" +
            "<td>Movie 11 wiki snap</td>\n" +
            "<td>Movie 11 wiki Directors</td>\n" +
            "<td>Movie 11 imdb url</td>\n" +
            "<td>Movie 11 imdb snap</td>\n" +
            "<td>Movie 11 imdb director</td>\n" +
            "<td>Movie 11 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2</td>\n" +
            "<td>Movie 12 name</td>\n" +
            "<td>Movie 12 wiki url</td>\n" +
            "<td>Movie 12 wiki snap</td>\n" +
            "<td>Movie 12 wiki Directors</td>\n" +
            "<td>Movie 12 imdb url</td>\n" +
            "<td>Movie 12 imdb snap</td>\n" +
            "<td>Movie 12 imdb director</td>\n" +
            "<td>Movie 12 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2</td>\n" +
            "<td>Movie 13 name</td>\n" +
            "<td>Movie 13 wiki url</td>\n" +
            "<td>Movie 13 wiki snap</td>\n" +
            "<td>Movie 13 wiki Directors</td>\n" +
            "<td>Movie 13 imdb url</td>\n" +
            "<td>Movie 13 imdb snap</td>\n" +
            "<td>Movie 13 imdb director</td>\n" +
            "<td>Movie 13 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>2</td>\n" +
            "<td>Movie 14 name</td>\n" +
            "<td>Movie 14 wiki url</td>\n" +
            "<td>Movie 14 wiki snap</td>\n" +
            "<td>Movie 14 wiki Directors</td>\n" +
            "<td>Movie 14 imdb url</td>\n" +
            "<td>Movie 14 imdb snap</td>\n" +
            "<td>Movie 14 imdb director</td>\n" +
            "<td>Movie 14 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4</td>\n" +
            "<td>Movie 15 name</td>\n" +
            "<td>Movie 15 wiki url</td>\n" +
            "<td>Movie 15 wiki snap</td>\n" +
            "<td>Movie 15 wiki Directors</td>\n" +
            "<td>Movie 15 imdb url</td>\n" +
            "<td>Movie 15 imdb snap</td>\n" +
            "<td>Movie 15 imdb director</td>\n" +
            "<td>Movie 15 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4</td>\n" +
            "<td>Movie 16 name</td>\n" +
            "<td>Movie 16 wiki url</td>\n" +
            "<td>Movie 16 wiki snap</td>\n" +
            "<td>Movie 16 wiki Directors</td>\n" +
            "<td>Movie 16 imdb url</td>\n" +
            "<td>Movie 16 imdb snap</td>\n" +
            "<td>Movie 16 imdb director</td>\n" +
            "<td>Movie 16 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4</td>\n" +
            "<td>Movie 17 name</td>\n" +
            "<td>Movie 17 wiki url</td>\n" +
            "<td>Movie 17 wiki snap</td>\n" +
            "<td>Movie 17 wiki Directors</td>\n" +
            "<td>Movie 17 imdb url</td>\n" +
            "<td>Movie 17 imdb snap</td>\n" +
            "<td>Movie 17 imdb director</td>\n" +
            "<td>Movie 17 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4</td>\n" +
            "<td>Movie 18 name</td>\n" +
            "<td>Movie 18 wiki url</td>\n" +
            "<td>Movie 18 wiki snap</td>\n" +
            "<td>Movie 18 wiki Directors</td>\n" +
            "<td>Movie 18 imdb url</td>\n" +
            "<td>Movie 18 imdb snap</td>\n" +
            "<td>Movie 18 imdb director</td>\n" +
            "<td>Movie 18 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4</td>\n" +
            "<td>Movie 19 name</td>\n" +
            "<td>Movie 19 wiki url</td>\n" +
            "<td>Movie 19 wiki snap</td>\n" +
            "<td>Movie 19 wiki Directors</td>\n" +
            "<td>Movie 19 imdb url</td>\n" +
            "<td>Movie 19 imdb snap</td>\n" +
            "<td>Movie 19 imdb director</td>\n" +
            "<td>Movie 19 differnce</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>4</td>\n" +
            "<td>Movie 20 name</td>\n" +
            "<td>Movie 20 wiki url</td>\n" +
            "<td>Movie 20 wiki snap</td>\n" +
            "<td>Movie 20 wiki Directors</td>\n" +
            "<td>Movie 20 imdb url</td>\n" +
            "<td>Movie 20 imdb snap</td>\n" +
            "<td>Movie 20 imdb director</td>\n" +
            "<td>Movie 20 differnce</td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "<!--===============================================================================================-->\n" +
            "<script src=\"vendor/jquery/jquery-3.2.2.min.js\"></script>\n" +
            "<!--===============================================================================================-->\n" +
            "<script src=\"vendor/bootstrap/js/popper.js\"></script>\n" +
            "<script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\n" +
            "<!--===============================================================================================-->\n" +
            "<script src=\"vendor/select2/select2.min.js\"></script>\n" +
            "<!--===============================================================================================-->\n" +
            "<!-- // <script src=\"vendor/perfect-scrollbar/perfect-scrollbar.min.js\"></script> -->\n" +
            "<!-- <script>\n" +
            "\tvar app = angular.module(\"myApp\", []);\n" +
            "            app.controller(\"myCtrl\", function($scope) {\n" +
            "            $scope.records = getJSON();\n" +
            "            console.log($scope.records);\n" +
            "            $scope.records = $scope.records.testCases;\n" +
            "            console.log($scope.records[0].Testcase[0]);\n" +
            "            console.log($scope.TestCaseName);\n" +
            "            });\n" +
            "</script> -->\n" +
            "<!--===============================================================================================-->\n" +
            "<script src=\"js/main.js\"></script>\n" +
            "\n" +
            "</body>\n" +
            "</html>\n");


    public void createJSON()
    {
        JSONObject jo = new JSONObject();
        JSONArray movies = new JSONArray();

        JSONObject movie1 = new JSONObject();
        movie1.put("movieid", "1");
        movie1.put("movieName", "1");
        movie1.put("wikiUrl", "1");
        movie1.put("wikiSnap", "1");
        movie1.put("wikiDir", "1");
        movie1.put("movieid", "1");
    }

}