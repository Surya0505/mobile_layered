package com.cg.mps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.mps.exceptions.MPSException;
import com.cg.mps.model.Mobiles;
import com.cg.mps.model.PurchaseDetails;
import com.cg.mps.utility.JDBCUtility;

public class MpsDaoImpl implements MpsDao {

	Connection connection = null;

	ResultSet resultSet = null;
	PreparedStatement statement = null;
	
	/**
	 * method      :  insertMobileDetails 
	 * argument    :  it's taking mobile object as an argument
	 * return type :  this method returns the number of rows inserted 
	 * Author      :  Capgemini 
	 * Date        :  18-Jan-2019
	 * 
	 */

	@Override
	public int insertMobileDetails(Mobiles mobiles) throws MPSException {
		connection = JDBCUtility.getConnection();
		int result = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.insertQuery);
			statement.setInt(1, mobiles.getMobileId());
			statement.setString(2, mobiles.getName());
			statement.setDouble(3, mobiles.getPrice());
			statement.setInt(4, mobiles.getQuantity());
			result = statement.executeUpdate();

		} catch (SQLException e) {
			throw new MPSException("No creation of prepared statement");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new MPSException("statement not closed");
			}

			try {
				connection.close();
			} catch (SQLException e) {
				throw new MPSException("connection not closed");
			}
		}
		return result;
	}
	
	/**
	 * method      :  updateMobileQuantity 
	 * argument    :  it's taking details object as an argument
	 * return type :  this method returns the number of rows inserted 
	 * Author      :  Capgemini 
	 * Date        :  18-Jan-2019
	 * 
	 */

	@Override
	public int updateMobileQuantity(PurchaseDetails details) throws MPSException {
		connection = JDBCUtility.getConnection();
		int update = 0;
		boolean result = false;
		try {
			statement = connection.prepareStatement(QueryMapper.checkMobileId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("mobile_id");
				if (id.equals(details.getMobileID())) {
					Integer id2 = resultSet.getInt("mobile_id");
					Integer quantity = resultSet.getInt("quantity");
                         
					if(quantity>0)
					{
					statement = connection.prepareStatement(QueryMapper.updateQuantity);
					statement.setInt(1, quantity - 1);
					statement.setInt(2, id2);
					statement.executeUpdate();

					statement = connection.prepareStatement(QueryMapper.insertPurchaseDetails);
					statement.setString(1, details.getcName());
					statement.setString(2, details.getMailId());
					statement.setLong(3, details.getPhoneNumber());
					statement.setInt(4, details.getMobileID());
					update=statement.executeUpdate();

					result = true;
					break;
					}else
					{
						System.out.println("No stock of that mobile");
					}
				}
			}
			if (!result) {
				System.out.println("No mobile is present with the given id");
			}
		} catch (SQLException e) {
			throw new MPSException("No creation of prepared statement");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new MPSException("statement not closed");
			}

			try {
				connection.close();
			} catch (SQLException e) {
				throw new MPSException("connection not closed");
			}
		}
		return update;
	}
	
	/**
	 * method      :  selectAllMobiles 
	 * argument    :  it's taking nothing as an argument
	 * return type :  this method returns the all rows in the table 
	 * Author      :  Capgemini 
	 * Date        :  18-Jan-2019
	 */

	@Override
	public List<Mobiles> selectAllMobiles() throws MPSException {
		connection = JDBCUtility.getConnection();
		List<Mobiles> list = new ArrayList<>();
		
		try {

			statement = connection.prepareStatement(QueryMapper.selectAllMobiles);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("mobile_id");
				String name = resultSet.getString("name");
				Double price = resultSet.getDouble("price");
				Integer quantity = resultSet.getInt("quantity");
				Mobiles mobiles = new Mobiles();
				mobiles.setMobileId(id);
				mobiles.setName(name);
				mobiles.setPrice(price);
				mobiles.setQuantity(quantity);
				list.add(mobiles);

			}
		} catch (SQLException e) {
			throw new MPSException("No creation of prepared statement");
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new MPSException("statement not closed");
			}

			try {
				connection.close();
			} catch (SQLException e) {
				throw new MPSException("connection not closed");
			}
		}
		
		return list;
	}
	
	/**
	 * method      :  deleteRow 
	 * argument    :  it's taking mobile ID as an argument
	 * return type :  this method returns the row that deleted from the table 
	 * Author      :  Capgemini 
	 * Date        :  18-Jan-2019
	 */

	@Override
	public int deleteRow(Integer id) throws MPSException {
		int result=0;
		connection = JDBCUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.DeleteRow);
			statement.setInt(1, id);
			result = statement.executeUpdate();
		} catch (SQLException e) {
			throw new MPSException("No creation of prepared statement");
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new MPSException("statement not closed");
			}

			try {
				connection.close();
			} catch (SQLException e) {
				throw new MPSException("connection not closed");
			}
		}
		return result;
	}
	
	/**
	 * method      :  mobileBetweenRange 
	 * argument    :  it's taking minimum and maximum price as an arguments
	 * return type :  this method returns the details of mobile between the given range 
	 * Author      :  Capgemini 
	 * Date        :  18-Jan-2019
	 */

	@Override
	public List<Mobiles> mobileBetweenRange(Double startRange, Double endRange) throws MPSException {
		
		List<Mobiles> list=new ArrayList<>();
		connection=JDBCUtility.getConnection();
		try {
			statement=connection.prepareStatement(QueryMapper.mobileBetweenRange);
			statement.setDouble(1, startRange);
			statement.setDouble(2, endRange);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("mobile_id");
				String name = resultSet.getString("name");
				Double price = resultSet.getDouble("price");
				Integer quantity = resultSet.getInt("quantity");
				Mobiles mobiles = new Mobiles();
				mobiles.setMobileId(id);
				mobiles.setName(name);
				mobiles.setPrice(price);
				mobiles.setQuantity(quantity);
				list.add(mobiles);
			}
		} catch (SQLException e) {
			throw new MPSException("No creation of prepared statement");
		}finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				throw new MPSException("resultSet not closed");
			}
			try {
				statement.close();
			} catch (SQLException e) {
				throw new MPSException("statement not closed");
			}

			try {
				connection.close();
			} catch (SQLException e) {
				throw new MPSException("connection not closed");
			}
		}
		
		return list;
	}

}
