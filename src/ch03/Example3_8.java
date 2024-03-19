package ch03;

/**
 * 
 * 【例3-8】停车场管理问题。
 * 
 */
import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Example3_8 {

	private SqStack S = new SqStack(100);// 顺序栈存放停车场内的车辆信息

	private LinkQueue Q = new LinkQueue();// 链队列存放便道上的车辆信息

	private double fee = 2;// 每分钟停车费用

	public final static int DEPARTURE = 0;// 标识车辆离开

	public final static int ARRIVAL = 1;// 标识车辆到达

	// 内部类用于存放车辆信息
	public class CarInfo {

		public int state;// 车辆状态，离开/到达

		public GregorianCalendar arrTime;// 车辆达到时间

		public GregorianCalendar depTime;// 车辆离开时间

		public String license;// 车牌号
	}

	// 停车场管理，参数license表示车牌号码，action表示此车辆的动作到达或离开
	public void parkingManag(String license, String action) throws Exception {
		if ("arrive".equals(action)) {// 车辆到达
			CarInfo info = new CarInfo();// 构造一个车辆信息实例
			info.license = license;// 修改车辆状态
			if (S.length() < 10) {// 停车场未满
				info.arrTime = (GregorianCalendar) GregorianCalendar
						.getInstance();// 当前时间初始化到达时间
				info.state = ARRIVAL;
				S.push(info);
				System.out.println(info.license + "停放在停车场第" + S.length()
						+ "个位置！");
			} else {// 停车场已满
				Q.offer(info);// 进入便道队列
				System.out.println(info.license + "停放在便道第" + Q.length()
						+ "个位置！");
			}

		} else if ("depart".equals(action)) {// 车辆离开
			CarInfo info = null;
			int location = 0;// 车辆的位置
			SqStack S2 = new SqStack(S.length());// 构造一个新栈用于存放因车辆离开而导致的其他车辆暂时退出车场
			for (int i = S.length(); i > 0; i--) {
				info = (CarInfo) S.pop();
				if (info.license.equals(license)) {// 将离开的车辆
					info.depTime = (GregorianCalendar) GregorianCalendar
							.getInstance();// 当前时间来初始化离开时间
					info.state = DEPARTURE;
					location = i;// 取得车辆位置信息
					break;
				} else
					// 其他车辆暂时退出车场
					S2.push(info);
			}

			while (!S2.isEmpty())
				// 其他车辆重新进入停车场
				S.push(S2.pop());

			if (location != 0) {// 停车场内存在指定车牌号码的车辆
				double time = (info.depTime.getTimeInMillis() - info.arrTime
						.getTimeInMillis())
						/ (1000 * 60);// 计算停放时间，并把毫秒换算成分钟
				DecimalFormat df = new DecimalFormat("0.0");// 对double进行格式化，保留两位有效小数
				System.out.println(info.license + "停放:" + df.format(time)
						+ "分钟，费用为:" + df.format(time * fee));// 输出
			}

			if (!Q.isEmpty()) {// 便道上的第一辆车进入停车场
				info = (CarInfo) Q.poll();
				info.arrTime = (GregorianCalendar) GregorianCalendar
						.getInstance();// 当前时间来初始化离开时间
				info.state = ARRIVAL;
				S.push(info);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Example3_8 pm = new Example3_8();// 构造对象
		for (int i = 1; i <= 12; i++)
			// 初始化12辆车，车牌号分别为1、2...12，其中有10辆车停在停车场内，2辆车停放在便道上
			pm.parkingManag(String.valueOf(i), "arrive");

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入车牌号：");
		String license = sc.next();
		System.out.println("arrive or depart ?");
		String action = sc.next();
		pm.parkingManag(license, action);// 调用停车场管理函数
	}
}
// 运行结果：
// 1停放在停车场第1个位置！
// 2停放在停车场第2个位置！
// 3停放在停车场第3个位置！
// 4停放在停车场第4个位置！
// 5停放在停车场第5个位置！
// 6停放在停车场第6个位置！
// 7停放在停车场第7个位置！
// 8停放在停车场第8个位置！
// 9停放在停车场第9个位置！
// 10停放在停车场第10个位置！
// 11停放在停车场第11个位置！
// 12停放在停车场第12个位置！
// 请输入车牌号：
// 2
// arrive or depart ?
// depart
// 2停放:8.0分钟，费用为:16.0

