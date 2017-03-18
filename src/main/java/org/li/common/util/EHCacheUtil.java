package org.li.common.util;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
/**
 * ehcache 缓存工具类
 *
 * cacheName在ehcache.xml中配置
 * Created by 衍君 on 2017/3/18.
 */
public class EHCacheUtil {
    public static String LOGIN_CACHE = "login-cache";
    public static EHCacheUtil instance = null;
    public static CacheManager manager;

    private EHCacheUtil(){
         manager = CacheManager.create();
    }
    public static EHCacheUtil getInstance(){
        if(instance == null){
            instance = new EHCacheUtil();
        }
        return  instance;
    }

        public Object get(String cacheName, Object key) {
            Cache cache = manager.getCache(cacheName);
            if (cache != null) {
                Element element = cache.get(key);
                if (element != null) {
                    return element.getObjectValue();
                }
            }
            return null;
        }

        public void put(String cacheName, Object key, Object value) {
            Cache cache = manager.getCache(cacheName);
            if (cache != null) {
                cache.put(new Element(key, value));
            }
        }

        public boolean remove(String cacheName, Object key) {
            Cache cache = manager.getCache(cacheName);
            if (cache != null) {
                return cache.remove(key);
            }
            return false;
        }

    }
