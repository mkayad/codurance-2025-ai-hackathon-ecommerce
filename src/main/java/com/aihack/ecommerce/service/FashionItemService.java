package com.aihack.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.aihack.ecommerce.model.FashionItem;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Service
public class FashionItemService {
    
    public List<FashionItem> getFashionItems() throws IOException {
        List<FashionItem> items = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ClassPathResource("styles.csv").getInputStream()))) {
            
            String line;
            br.readLine(); // Skip header
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                
                // Create FashionItem with all required fields
                int year = 0;
                if (values[7] != null && !values[7].trim().isEmpty()) {
                    year = Integer.parseInt(values[7]);
                }
                
                FashionItem item = new FashionItem(
                    values[0],  // id
                    values[1],  // gender
                    values[2],  // masterCategory
                    values[3],  // subCategory
                    values[4],  // articleType
                    values[5],  // baseColour
                    values[6],  // season
                    year,  // year - default to 0 if empty
                    values[8],  // usage
                    values[9],  // productDisplayName
                    "",  // name
                    "",  // description
                    0.0,  // price
                    ""    // imageUrl
                );
                
                items.add(item);
            }
        }
        
        return items;
    }
    
    public ResponseEntity<String> getFashionItemsAsCsv() throws IOException {
        List<FashionItem> items = getFashionItems();
        
        StringWriter writer = new StringWriter();
        // Write header
        writer.write("id,gender,masterCategory,subCategory,articleType,baseColour,season,year,usage,productDisplayName\n");
        
        for (FashionItem item : items) {
            writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%d,%s,%s\n",
                item.getId(),
                item.getGender(),
                item.getMasterCategory(),
                item.getSubCategory(),
                item.getArticleType(),
                item.getBaseColour(),
                item.getSeason(),
                item.getYear(),
                item.getUsage(),
                item.getProductDisplayName()
            ));
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentDispositionFormData("attachment", "fashion_items.csv");
        
        return ResponseEntity.ok()
            .headers(headers)
            .body(writer.toString());
    }
}
