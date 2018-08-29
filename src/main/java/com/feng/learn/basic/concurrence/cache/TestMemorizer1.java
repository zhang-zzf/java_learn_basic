package com.feng.learn.basic.concurrence.cache;

import java.util.ArrayList;
import java.util.List;

public class TestMemorizer1 {
	
	public static void main(String args[]){
		Computable<String,Integer> c=new ComputableImpl();
		
		final Computable<String,Integer> cachedComputable=new Memorizer1<String, Integer>(c);
		
		final List<String> datas=new ArrayList<String>();
		
		for (int i=0;i<10;i++){
			
			final String str="Hello: "+i;
			datas.add(str);
			/**
			 * 这里虽然启动了10个线程，但cachedComputable 是单线程处理逻辑和速度。
			 */
			Thread thread = new Thread(){

				@Override
				public void run() {
					try {
						cachedComputable.compute(str);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			};
			thread.start();
		}
		
	}

}
