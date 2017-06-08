package utils;

public class JudgeSQL {
	public static String jSQL(String tableName,String colName,String colNameData,int limit,String order,int skip){
		String slimit;
		String sorder;
		String sSkip;
		String scolNmae;
		if(limit ==0){
			 slimit = "";
		}else{
			slimit ="Top "+limit;
		};
		if(order ==null){
			sorder = "";
		}else{
			String opt = order.substring(0,1);
			String col = order.substring(1);
			if(opt.equals("+")){
				sorder ="order by "+col+" ASC ";
			}else{
				sorder ="order by "+col+" DESC ";
			}
		};
		if(colName==null){
			scolNmae="";
		}else{
			scolNmae=""+colName+" = '"+colNameData+"' and";
		}
		if(skip==0){
			sSkip = "";
		}else{
			if(order==null){
				sorder = "";
			}else{
				String opt = order.substring(0,1);
				String col = order.substring(1);
				if(opt.equals("+")){
					sorder ="order by "+col+" ASC ";
				}else{
					sorder ="order by "+col+" DESC ";
				}
			};
			sSkip = "where "+scolNmae+" id not in (select top "+skip+" id from feedback "+sorder+")";
		}
		return "select "+slimit+" * from feedback "+sSkip+" "+sorder+"";
	}
}
