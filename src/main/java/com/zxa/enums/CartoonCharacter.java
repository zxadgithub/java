package com.zxa.enums;

import java.util.Random;

/**
 * @EnumName: CartoonCharacter
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/9/29 9:26
 */
interface Generator<T>{
	T next();
}
public enum CartoonCharacter implements  Generator<CartoonCharacter> {
	SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
	private Random rand = new Random(47);
	@Override
	public CartoonCharacter next() {
		return values()[rand.nextInt(values().length)];
	}
}

class MainTest{

	public static <T> void printNext(Generator<T> arg){
		System.out.println(arg.next() + ",");
	}
	public static void main(String[] args) {
		CartoonCharacter cc = CartoonCharacter.BOB;
		for(int i = 0; i < 10; i++){
			printNext(cc);
		}
	}
}
