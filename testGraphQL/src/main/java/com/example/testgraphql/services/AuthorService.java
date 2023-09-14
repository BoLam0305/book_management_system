package com.example.testgraphql.services;

import com.example.testgraphql.modules.Author;
import com.example.testgraphql.modules.AuthorInput;
import java.util.Map;

public interface AuthorService {
	Author convertToAuthorInput(Map<String, Object> obj);
}
