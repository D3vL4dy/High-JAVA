CREATE TABLE BANKINFO(
    BANK_NO VARCHAR2(40) NOT NULL, --���¹�ȣ
    BANK_NAME VARCHAR2(40) NOT NULL, --�����
    BANK_USER_NAME VARCHAR2(30) NOT NULL, --�����ָ�,
    BANK_DATE DATE NOT NULL, --���� ��¥
    CONSTRAINT PK_BANKINFO PRIMARY KEY (BANK_NO)
);

insert into bankinfo (bank_no, bank_name, bank_user_name, bank_date)
 values('111-111-111', '����', 'ȫ�浿', sysdate);
 
 /*
    .ȸ��ID : ss' or '1'='1
    
    String memId = "a001";
    
    "select * from member where mem_Id = '" + memId + "'";
    
    "select * from member where mem_Id = ?";
 */
 
 select * from member where mem_id = 'a001';
 
 select * from member where mem_id = 'ss' or '1'='1';
 
 select * from member where mem_id = 'ss'' or ''1''=''1'; 
 
 select 'ss'' or ''1''=''1' from dual;
 
