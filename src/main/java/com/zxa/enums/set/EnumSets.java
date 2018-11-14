package com.zxa.enums.set;

import com.sun.media.sound.SoftTuning;

import java.util.EnumSet;
import static com.zxa.enums.set.AlarmPoints.*;
/**
 * @ClassName: EnumSets
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/9/29 10:25
 */
public class EnumSets {
	public static void main(String[] args) {
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);

		points.add(BATHROOM);
		System.out.println(points);
		System.out.println("contains BATHROOM : " + points.contains(BATHROOM));
		points.addAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
		System.out.println(points);

		points = EnumSet.allOf(AlarmPoints.class);
		points.removeAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
		System.out.println(points);

		points.removeAll(EnumSet.range(OFFICE1,OFFICE3));
		System.out.println(points);

		points = EnumSet.complementOf(points);
		System.out.println(points);
	}
}


