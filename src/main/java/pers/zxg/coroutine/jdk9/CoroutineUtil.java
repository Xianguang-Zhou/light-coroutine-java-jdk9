/*
 * Copyright (c) 2022, Xianguang Zhou <xianguang.zhou@outlook.com>. All rights reserved.
 */
package pers.zxg.coroutine.jdk9;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import pers.zxg.coroutine.Coroutine.OutsideCall;
import pers.zxg.coroutine.Coroutine.Suspend;
import pers.zxg.coroutine.Coroutine.Weaver.NotWeaved;

/**
 * @author <a href="mailto:xianguang.zhou@outlook.com">Xianguang Zhou</a>
 */
public class CoroutineUtil extends pers.zxg.coroutine.jdk8.CoroutineUtil {

	public static interface Future<T> extends pers.zxg.coroutine.jdk8.CoroutineUtil.Future<T> {

		@Override
		public T get(long timeout, TimeUnit unit) throws Suspend, ExecutionException, TimeoutException, OutsideCall;
	}

	public static class Promise<T> extends pers.zxg.coroutine.jdk8.CoroutineUtil.Promise<T> implements Future<T> {

		@Override
		public T get(long timeout, TimeUnit unit) throws Suspend, ExecutionException, TimeoutException, OutsideCall {
			throw new NotWeaved();
		}
	}

	public static void sleep(long time, TimeUnit unit) throws Suspend, OutsideCall {
		throw new NotWeaved();
	}

	public static <T> T await(CompletionStage<T> stage, long timeout, TimeUnit unit)
			throws Suspend, ExecutionException, TimeoutException, OutsideCall {
		throw new NotWeaved();
	}
}
