package com.Simple_Blog.repsitory;

import java.util.List;

public interface ParentOfAllRepositories<T> {
    List<T> getAll();

}
