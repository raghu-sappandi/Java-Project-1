package com.bank.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bank.connector.Connector;
import com.bank.dto.Customer;

public class CustomerDAO_imp1 implements CustomerDAO{
	private Connection con;
	public CustomerDAO_imp1()
	{
		this.con=Connector.requestConnection();
	}
	@Override
	public boolean insertCustomer(Customer c) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="insert into customer(name,phone,mail,pin)values(?,?,?,?);";
		int res=0;
		
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setString(1,c.getName());
			ps.setLong(2, c.getPhone());
			ps.setString(3, c.getMail());
			ps.setInt(4, c.getPin());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(res>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
	}
	@Override
	public Customer getCustomer(long accno, int pin) {
		
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer c=null;
		String query="select * from customer where acc_no=? and pin=?;";
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1,accno);
			ps.setInt(2, pin);
			rs=ps.executeQuery();
			if(rs.next()) {
				c=new Customer();
				c.setAccno(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public Customer getCustomer(long phone, String mail) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer c=null;
		String query="select * from customer where phone=? and mail=?;";
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1,phone);
			ps.setString(2, mail);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				c=new Customer();
				c.setAccno(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public Customer getCustomer(long accno) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer c=null;
		String query="select * from customer where acc_no=?";
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1,accno);
			
			
			rs=ps.executeQuery();
			if(rs.next()) {
				c=new Customer();
				c.setAccno(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public List getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updateCustomer(Customer c) {
		PreparedStatement ps = null;
		int res=0;
		String query="update customer set name=?,phone=?,mail=?,balance=?,pin=? where acc_no=?;";
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setString(1, c.getName());
			ps.setLong(2, c.getPhone());
			ps.setString(3, c.getMail());
			ps.setDouble(4, c.getBal());
			ps.setInt(5, c.getPin());
			ps.setLong(6, c.getAccno());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
		}
	}
	@Override
	public boolean deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}
}
