package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    LRUCache lruCache;
    OriginalRetriever originalRetriever;

    public CachingProxyRetriever (Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
        lruCache = new LRUCache(10);
    }

    public Object retrieve(long id) {
        Object get = lruCache.find(id);
        if (get != null) {
            return get;
        } else  {
            get = originalRetriever.retrieve(id);
            lruCache.set(id, get);
            return get;
        }
    }
}
