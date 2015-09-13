package cn.edu.zju.coffee.hiho.ntest2015septdm.no2;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * Problem Description: http://hihocoder.com/contest/ntest2015septdm/problem/2
 * @author zkf
 *
 */

public class Main {
	
	class Channel{
		int cid;
		String name;
		int ctype;
		
		void input(String attr, String val){
			switch (attr) {
			case "cid":
				cid = Integer.parseInt(val);
				break;
				
			case "name":
				name = val;
				break;
				
			case "ctype":
				ctype = Integer.parseInt(val);
				break;

			default:
				break;
			}
		}
	}
	
	class Player{
		int pid;
		String name;
		int cid;
		
		void input(String attr, String val){
			switch (attr) {
			case "cid":
				cid = Integer.parseInt(val);
				break;
				
			case "name":
				name = val;
				break;
				
			case "pid":
				pid = Integer.parseInt(val);
				break;

			default:
				break;
			}
		}
	}
	
	class Prepaid{
		int id;
		int pid;
		int cash;
		
		void input(String attr, String val){
			switch (attr) {
			case "id":
				id = Integer.parseInt(val);
				break;
				
			case "cash":
				cash = Integer.parseInt(val);
				break;
				
			case "pid":
				pid = Integer.parseInt(val);
				break;

			default:
				break;
			}
		}
	}
	
	class PlayerChannel{
		int pid;
		int ctype;
	}
	
	class ChannelPrepaid{
		int pid;
		int ctype;
		int cash;
		@Override
		public String toString() {
			return "ChannelPrepaid [pid=" + pid + ", ctype=" + ctype
					+ ", cash=" + cash + "]";
		}
	}
	
	class Final{
		int ctype;
		int pcnt;
		int cash;
		@Override
		public String toString() {
			return String.format("%d %d %d", ctype, pcnt, cash);
		}
	}
	
	public List<Final> groupBy(List<ChannelPrepaid> cps){
//		Map<Integer, List<ChannelPrepaid>> retMap = new HashMap<Integer, List<ChannelPrepaid>>();
		List<Final> finalList = new LinkedList<Final>();
		Map<Integer, Set<Integer>> pidMap = new HashMap<Integer, Set<Integer>>();
		Map<Integer, Integer> cashSumMap = new HashMap<Integer, Integer>();
		for(ChannelPrepaid cp: cps){
//			List<ChannelPrepaid> list = retMap.get(cp.ctype);
			Set<Integer> pidSet = pidMap.get(cp.ctype);
			Integer cashSum = cashSumMap.get(cp.ctype);
			if(cashSum == null)
				cashSum = 0;
			if(pidSet == null){
//				list = new LinkedList<ChannelPrepaid>();
//				retMap.put(cp.ctype, list);
				
				pidSet = new HashSet<Integer>();
				pidMap.put(cp.ctype, pidSet);
			}
			
//			list.add(cp);
			pidSet.add(cp.pid);
			cashSum += cp.cash;
			cashSumMap.put(cp.ctype, cashSum);
		}
		
		for(Integer ctype: pidMap.keySet()){
			Final f = new Final();
			f.pcnt = pidMap.get(ctype).size();
			f.cash = cashSumMap.get(ctype);
			f.ctype = ctype;
			
			finalList.add(f);
		}
		
		Comparator<Final> cmp = new Comparator<Final>() {
			
			@Override
			public int compare(Final o1, Final o2) {
				int res = o2.cash - o1.cash;
				if(res == 0)
					return o1.ctype - o2.ctype;
				else
					return res;
			}
		};
		Collections.sort(finalList, cmp);
		
		return finalList;
	}
	
	
	public List<ChannelPrepaid> join2(Map<Integer, PlayerChannel> pcs, Map<Integer, Prepaid> pps){
		List<ChannelPrepaid> retMap = new LinkedList<ChannelPrepaid>();
		
		Map<Integer, List<Prepaid>> tmpMap = new HashMap<Integer, List<Prepaid>>();
		for(Prepaid pp: pps.values()){
			int pid = pp.pid;
			List<Prepaid> list = tmpMap.get(pid);
			if(list == null){
				list = new LinkedList<Main.Prepaid>();
				tmpMap.put(pid, list);
			}
			
			list.add(pp);
		}
		
		for(PlayerChannel pc: pcs.values()){
			int cash, pid, ctype;
			List<Prepaid> ppList = tmpMap.get(pc.pid);
			pid = pc.pid;
			ctype = pc.ctype;
			if(ppList == null){
				cash = 0;
				ChannelPrepaid cp = new ChannelPrepaid();
				cp.pid = pid;
				cp.cash = cash;
				cp.ctype = ctype;
				retMap.add(cp);
			}
			else{
				for(Prepaid pp: ppList){
					cash = pp.cash;
					ChannelPrepaid cp = new ChannelPrepaid();
					cp.pid = pid;
					cp.cash = cash;
					cp.ctype = ctype;
					retMap.add(cp);
				}
			}
		}
		
		return retMap;
	}
	
	
	public Map<Integer, PlayerChannel> join1(Map<Integer, Channel> channels, Map<Integer, Player> players){
		Map<Integer, PlayerChannel> retMap = new HashMap<Integer, PlayerChannel>();
		for(Player p: players.values()){
			int pid = p.pid, ctype;
			Channel ch = channels.get(p.cid);
			if(ch == null)
				ctype = -1;
			else
				ctype = ch.ctype;
			
			PlayerChannel pc = new PlayerChannel();
			pc.pid = pid;
			pc.ctype = ctype;
			
			retMap.put(pid, pc);
		}
		
		return retMap;
	}
	
	public void inputChannels(Map<Integer, Channel> chs, Scanner scanner){
		int cnt = scanner.nextInt();
		String attr1 = scanner.next();
		String attr2 = scanner.next();
		String attr3 = scanner.next();
		for(int i=0; i< cnt; i++){
			String val1 = scanner.next();
			String val2 = scanner.next();
			String val3 = scanner.next();
			
			Channel ch = new Channel();
			ch.input(attr1, val1);
			ch.input(attr2, val2);
			ch.input(attr3, val3);
			
			chs.put(ch.cid, ch);
		}
	}
	
	public void inputPlayers(Map<Integer, Player> pls, Scanner scanner){
		int cnt = scanner.nextInt();
		String attr1 = scanner.next();
		String attr2 = scanner.next();
		String attr3 = scanner.next();
		for(int i=0; i< cnt; i++){
			String val1 = scanner.next();
			String val2 = scanner.next();
			String val3 = scanner.next();
			
			Player pl = new Player();
			pl.input(attr1, val1);
			pl.input(attr2, val2);
			pl.input(attr3, val3);
			pls.put(pl.pid, pl);
		}
	}
	
	public void inputPrepaid(Map<Integer, Prepaid> pps, Scanner scanner){
		int cnt = scanner.nextInt();
		
		String attr1 = scanner.next();
		String attr2 = scanner.next();
		String attr3 = scanner.next();
		for(int i=0; i< cnt; i++){
			String val1 = scanner.next();
			String val2 = scanner.next();
			String val3 = scanner.next();
			
			Prepaid pp = new Prepaid();
			pp.input(attr1, val1);
			pp.input(attr2, val2);
			pp.input(attr3, val3);
			pps.put(pp.id, pp);
		}
	}
	
	public void deal(){
		Scanner scanner = new Scanner(System.in);
		Map<Integer, Channel> chs = new HashMap<Integer, Channel>();
		Map<Integer, Player> pls = new HashMap<Integer, Player>();
		Map<Integer, Prepaid> pps = new HashMap<Integer, Prepaid>();
		
		String tbName;
		for(int i=0; i<3; i++){
			tbName = scanner.next();
			switch (tbName) {
			case "channels":
				inputChannels(chs, scanner);
				break;
			case "players":
				inputPlayers(pls, scanner);
				break;
			case "prepaids":
				inputPrepaid(pps, scanner);
				break;

			default:
				break;
			}
		}
		
		Map<Integer, PlayerChannel> pcs = join1(chs, pls);
		List<ChannelPrepaid> cps = join2(pcs, pps);
//		for(ChannelPrepaid cp: cps)
//			System.out.println(cp);
		
		List<Final> finals = groupBy(cps);
		for(Final f: finals)
			System.out.println(f);
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		new Main().deal();
	}
}
