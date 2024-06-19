package com.insight.backend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.insight.backend.model.Category;
import com.insight.backend.model.Rating;
import com.insight.backend.model.nestedRatings.RatingList;

/**
 * Controller for handling rating-related requests.
 */
@RestController
public class RatingController {

    /**
     * Handles GET requests for retrieving ratings for a specific audit.
     *
     * @param auditId the ID of the audit
     * @return a ResponseEntity containing the ratings in JSON format or an error message if the audit ID does not exist
     */
    @GetMapping("/api/v1/audits/{auditId}/ratings")
    public ResponseEntity<List<Map<String, Object>>> get(@PathVariable("auditId") Integer auditId) {

        // Generate Test-Categories
        Category category1 = new Category("categorytest1", null);
        Category category2 = new Category("categorytest2", null);
        Category category3 = new Category("categorytest3", null);

        // Generate Test-Ratings
        Rating rating1 = new Rating("Bob", false, "KOmmentar", 0, null, null);
        Rating rating2 = new Rating("Ben", false, "Kommentar2", 3, null, null);
        Rating rating3 = new Rating("Boris", false, "Kommentar3", 1, null, null);
        Rating rating4 = new Rating("Berthold", false, "Kommentar4", 4, null, null);

        // Generate Test-Lists containing Test-Ratings
        List<Rating> ratings1 = new ArrayList<>();
        ratings1.add(rating1);
        ratings1.add(rating2);
        RatingList ratingList1 = new RatingList(ratings1);

        List<Rating> ratings2 = new ArrayList<>();
        ratings2.add(rating3);
        ratings2.add(rating4);
        RatingList ratingList2 = new RatingList(ratings2);

        // Contain Test-Lists within HashMap as Audit-Simulation (Key-ID = AuditID)
        HashMap<Integer, RatingList> ratingsAssigned = new HashMap<>();
        ratingsAssigned.put(1, ratingList1);
        ratingsAssigned.put(2, ratingList2);

        Map<String, Object> category = new HashMap<>();
        category.put("id", 0);
        category.put("name", "string");

        // Erstellen des Items
        Map<String, Object> item = new HashMap<>();
        item.put("id", 0);
        item.put("category", category);
        item.put("question", "string");
        item.put("points", 0);
        item.put("comment", "string");
        item.put("na", false);

        Map<String, Object> item2 = new HashMap<>();
        item2.put("id", 1);
        item2.put("category", category);
        item2.put("question", "whats life all about?");
        item2.put("points", 3);
        item2.put("comment", "test test test");
        item2.put("na", true);

        // Hinzufügen des Items zur Liste
        List<Map<String, Object>> items = new ArrayList<>();
        items.add(item);
        items.add(item2);

        return ResponseEntity.ok(items);


        // // Error Handling 404 - Non-existing Audit
        // if (ratingsAssigned.containsKey(auditId)) {
        //     return ResponseEntity.ok(ratingsAssigned.get(auditId));
        // } else {
        //     return ResponseEntity.notFound().build();
        // }
    }
}