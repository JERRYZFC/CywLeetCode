package com.cyw.agentmode;

/**
 * 代理模式
 * 1、安全因素
 * 2、远程调用处理
 * 3、提升系统性能，对真实对象进行封装，从而达到延迟加载的目的。
 * @author cyw
 *
 * 延迟加载的核心是：如果当前并没有使用这个组件，那么不需要真正的初始化它，使用一个代理对象
 * 替代他的原有位置，只要在真正需要使用的时候，才对她进行加载。
 * 在需要的时候，才使用
 */
//以下是一个数据库查询操作类。主题接口。是代理类与真实类的对外提供的服务。
public interface IDBQuery {
	String request();
}
