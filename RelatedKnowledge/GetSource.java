//get the data from the sql 
//then put the data to the arraylist


假设mysql中test数据库中有个表式score，有数据，我只取第一列的数据出来：
public void mysqlConnection(){
 try {
   Class.forName("com.mysql.jdbc.Driver").newInstance();//数据库驱动
   String url = "jdbc:mysql://localhost:3306/test";//数据库链接地址
   String user = "root";//用户名
   String password = "";//密码
   Connection conn = DriverManager.getConnection(url, user, password);//建立connection
   Statement stmt = conn.createStatement();
   conn.setAutoCommit(false);// 更改jdbc事务的默认提交方式 

   String sql = "select * from score";//查询语句
   ResultSet rs = stmt.executeQuery(sql);//得到结果集
   conn.commit();//事务提交
   conn.setAutoCommit(true);// 更改jdbc事务的默认提交方式 
   List<String> list=new ArrayList<String>();//创建取结果的列表，之所以使用列表，不用数组，因为现在还不知道结果有多少，不能确定数组长度，所有先用list接收，然后转为数组
   while (rs.next()) {//如果有数据，取第一列添加如list
    list.add(rs.getString(1));
   }
   if(list != null && list.size()>0){//如果list中存入了数据，转化为数组
                               String[] arr=new String[list.size()];//创建一个和list长度一样的数组
    for(int i=0;i<list.size();i++){
     arr[i]=list.get(i);//数组赋值了。
    }
                               //输出数组
                              for(int i=0;i<arr.length;i++){
                                   System.out.println(arr[i]);
                                 }
   }
   
  } catch (Exception e) {
   // TODO Auto-generated catch block   
   e.printStackTrace();
  }
}

//搞定。。。。。。。。。。。。。。。
