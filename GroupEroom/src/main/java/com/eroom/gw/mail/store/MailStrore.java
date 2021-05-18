package com.eroom.gw.mail.store;

import java.util.List;
import java.util.Map;

import com.eroom.gw.mail.domain.Mail;

public interface MailStrore {
 
	
	
	public void create(Mail mail) throws Exception;
     
     public void create2(Mail mail) throws Exception;  
     
     public void create3(Mail mail) throws Exception;   

     public Mail read(Map param) throws Exception;

     public void update(Map param) throws Exception;

     public void delete(Map param) throws Exception;

     public List<Mail> sndListAll(Mail mail) throws Exception;
     
     public List<Mail> rcvListAll(Mail mail) throws Exception;
     
    
     
     public int rcvCount(String stf_rcv_sq)throws Exception;
     
     public int sndCount(String stf_snd_sq)throws Exception;
     
    
     
     public int rcvSearchCount(Mail mail)throws Exception;
     
     public int sndSearchCount(Mail mail)throws Exception;
     
     
}

