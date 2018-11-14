package com.zxa.enums.dispense;

import java.io.Writer;
import java.util.EnumMap;
import static com.zxa.enums.dispense.Outcome.*;
/**
 * @ClassName: RoshamBo5
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/10/9 10:52
 */
public enum RoshamBo5 implements Competitor<RoshamBo5> {
	PAPER, SCISSORS, ROCK;
	static EnumMap<RoshamBo5,EnumMap<RoshamBo5,Outcome>> table = new EnumMap(RoshamBo5.class);
	static {
		for(RoshamBo5 it : RoshamBo5.values()){
			table.put(it, new EnumMap<RoshamBo5, Outcome>(RoshamBo5.class));
		}
		initRow(PAPER, DRAW, LOSE, WIN);
		initRow(SCISSORS,WIN,DRAW,LOSE);
		initRow(ROCK,LOSE,WIN,DRAW);
	}

	private static void initRow(RoshamBo5 it,  Outcome vPAPER, Outcome vSCISSORS, Outcome vROCK) {
		EnumMap<RoshamBo5,Outcome> row = RoshamBo5.table.get(it);
		row.put(RoshamBo5.PAPER,vPAPER);
		row.put(RoshamBo5.SCISSORS, vSCISSORS);
		row.put(RoshamBo5.ROCK,vROCK);
	}

	@Override
	public Outcome compete(RoshamBo5 competitor) {
		return table.get(this).get(competitor);
	}

	public static void main(String[] args) {
		RoshamBo.play(RoshamBo5.class,20);
	}
}
