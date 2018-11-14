package com.zxa.enums.menu;

/**
 * @ClassName: Food
 * @Description: 接口组织枚举
 * @Author: zhangxin_an
 * @CreateDate: 2018/9/29 10:08
 */
public interface Food {
	enum  Appetizer implements Food{
		SALAD,SOUP,SPRING_ROLLS;
	}

	enum MainCourse implements Food{
		LASAGNE,BURRUTO,PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
	}

	enum Dessert implements Food{
		RITAMISU, GELATO,FRUIT;
	}

	enum Coffee implements Food{
		BLACK_COFFEE, DECAF_CAFFEE, ESPRESSO;
	}
}

class TypeOfFoodTest{
	public static void main(String[] args) {
		Food food = Food.Appetizer.SALAD;
		food = Food.Coffee.BLACK_COFFEE;
	}
}
