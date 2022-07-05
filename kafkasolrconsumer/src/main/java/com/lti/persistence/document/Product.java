package com.lti.persistence.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.Data;

@Data
@SolrDocument(collection = "gettingstarted")
public class Product {
    @Id
    @Indexed(name = "id", type = "string")
    private String id;

    @Indexed(name = "name", type = "string")
    private String name;
}