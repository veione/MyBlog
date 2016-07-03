package com.java.blog.utils;

import java.util.Properties;
import java.util.Set;

import lombok.extern.log4j.Log4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Log4j
public class RedisUtils {

	private static JedisPool jedisPool;// 连接池

	static {
		// 1、获取配置
		Properties p = PropertiesUtil.getProperties("common.properties");
		// 2、初始化相关配置
		String host = p.getProperty("redis.host");// 主机
		Integer port = Integer.valueOf(p.getProperty("redis.port"));// 端口
		Integer timeout = Integer.parseInt(p.getProperty("redis.timeout"));// 连接超时
		String password = p.getProperty("redis.pass");// 密码
		// 3、获取默认配置，并初始化连接池
		JedisPoolConfig config = new JedisPoolConfig();
		jedisPool = new JedisPool(config, host, port, timeout, password);
	}

	/**
	 * @Describe:普通获取数据
	 */
	public static String get(String key) {
		String value = null;
		Jedis jedis = jedisPool.getResource();
		try {
			value = jedis.get(key);
		} catch (Exception e) {
			log.error("获取redis数据时发生异常", e);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return value;
	}

	/**
	 * @Describe:删除数据
	 */
	public static Long del(String key) {
		Long value = null;
		Jedis jedis = jedisPool.getResource();
		try {
			value = jedis.del(key);
		} catch (Exception e) {
			log.error("删除redis数据时发生异常", e);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return value;
	}

	/**
	 * @Describe:是否存在
	 */
	public static Boolean exists(String key) {
		Boolean isExists = false;
		Jedis jedis = jedisPool.getResource();
		try {
			isExists = jedis.exists(key);
		} catch (Exception e) {
			log.error("检测redis数据是否存在时发生异常", e);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return isExists;
	}

	public static String set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {
			log.error(e);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return value;
	}

	public static String hget(String key, String field) {
		if (key != null) {
			Jedis jedis = null;
			String value = null;
			try {
				jedis = jedisPool.getResource();

				value = jedis.hget(key, field);
			} catch (Exception e) {
				log.error(e);
			} finally {
				if (jedis != null) {
					jedis.close();
				}
			}
			return value;
		}
		return null;
	}

	public static void sadd(String key, final String... members) {
		if (key != null) {
			Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();

				jedis.sadd(key, members);
			} catch (Exception e) {
				log.error(e);
			} finally {
				if (jedis != null) {
					jedis.close();
				}
			}
		}
	}

	public static Set<String> smembers(String key) {
		if (key != null) {
			Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();

				return jedis.smembers(key);
			} catch (Exception e) {
				log.error(e);
			} finally {
				if (jedis != null) {
					jedis.close();
				}
			}
		}
		return null;
	}

	public static void hset(String key, String field, String value) {
		if (key != null) {
			Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();

				jedis.hset(key, field, value);
			} catch (Exception e) {
				log.error(e);
			} finally {
				if (jedis != null) {
					jedis.close();
				}
			}
		}
	}

	public static Long hdel(String key, String field) {
		if (key != null) {
			Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();

				return jedis.hdel(key, field);
			} catch (Exception e) {
				log.error(e);
			} finally {
				if (jedis != null) {
					jedis.close();
				}
			}
		}
		return null;
	}
}
