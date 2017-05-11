package com.ap.ass2.model;

public class Message {  
   //private String MMQBH;  //密码器编号
    private String ID;
   //private String SCCS;   //生产厂商  
    private String Type;
   //private String ZT;    //密码器状态 
    private String Name;
   // private int KHH;      //客户号  
    private int Age;
   // private String KHMC;  //客户名称 
   private String State;
    //private String BHFX;  //是否本行发行  
    //private String FXRQ;  //发行登记日期  
    //private String CJR;   //创建人  
    public Message(){};  
    public Message(String ID,String Type,String Name,int Age,String State){  
        this.ID = ID;  
        this.Type = Type;  
        this.Name = Name;  
        this.Age = Age;  
        this.State = State;  
       // this.BHFX = BHFX;  
       // this.FXRQ = FXRQ;  
       // this.CJR = CJR;  
    };  
    /** 
     * @return the MMQBH 
     */  
    public String getID() {  
        return ID;  
    }  
  
    /** 
     * @param MMQBH the MMQBH to set 
     */  
    public void setID(String id) {  
        this.ID = id;  
    }  
  
    /** 
     * @return the SCCS 
     */  
    public String getType() {  
        return Type;  
    }  
  
    /** 
     * @param SCCS the SCCS to set 
     */  
    public void setType(String type) {  
        this.Type = type;  
    }  
  
    /** 
     * @return the ZT 
     */  
    public String getName() {  
        return Name;  
    }  
  
    /** 
     * @param ZT the ZT to set 
     */  
    public void setName(String name) {  
        this.Name = name;  
    }  
  
    /** 
     * @return the KHH 
     */  
    public int getAge() {  
        return Age;  
    }  
  
    /** 
     * @param KHH the KHH to set 
     */  
    public void setAge(int age) {  
        this.Age = age;  
    }  
  
    /** 
     * @return the KHMC 
     */  
    public String getState() {  
        return State;  
    }  
  
    /** 
     * @param KHMC the KHMC to set 
     */  
    public void setState(String state) {  
        this.State = state;  
    }
	public void setItems(Message table) {
		// TODO Auto-generated method stub
		
	}  
  
    
    
      
}  