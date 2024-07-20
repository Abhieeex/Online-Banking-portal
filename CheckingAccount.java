ResultSet reslt = stat.executeQuery(SQL_Command);

					while (reslt.next()) {
						 Balance = reslt.getFloat(1);
						}
					Balance = Balance + Amount;
					SQL_Command = "UPDATE CheckingAccount SET Balance = '" + Balance + "' WHERE CheckingAccountNumber = '"+CheckingAccountNumber+"'";
					System.out.println(SQL_Command);
					stat.executeUpdate(SQL_Command);
					stat.close();
					DBconn.closeConn();
					}
				}

			catch (SQLException e){
				System.out.println("SQLException" + e);
				done= false;
				System.out.println("SQLExceptionState" + e.getSQLState());
				System.out.println("message" + e.getMessage());
				System.out.println("vendor" + e.getErrorCode());
				e.getNextException();
				System.out.println("");
			}

			catch (java.lang.Exception e){

				System.out.println("Exception" + e);
				e.printStackTrace();
			}

			return done;
	}
	public boolean Withdraw(String C_ID){

			boolean done = !CheckingAccountNumber.equals("") && !CustomerID.equals("");

			try{
				if(done){
					DBConnection DBconn = new DBConnection();
					Connection Conn = DBconn.openConn();
					Statement Stat = Conn.createStatement();
					String SQL_Command = "SELECT Balance FROM CheckingAccount WHERE CheckingAccountNumber = '"+CheckingAccountNumber+"' AND CustomerID= '"+C_ID+"' ";
					System.out.println(SQL_Command);
					ResultSet rslt = Stat.executeQuery(SQL_Command);
					while (rslt.next()) {
						 Balance = rslt.getFloat(1);
					}
					if (Balance>=Amount) {
						Balance = Balance - Amount;
						SQL_Command = "UPDATE CheckingAccount SET Balance = '"+Balance+"' WHERE  CheckingAccountNumber = '"+CheckingAccountNumber+"'";
						System.out.println(SQL_Command);
						Stat.executeUpdate(SQL_Command);
						Stat.close();
						DBconn.closeConn();

					}
				}
			}
			catch (java.sql.SQLException e){

				System.out.println("SQLException" + e);
				while (e != null){
					System.out.println("SqlExceptionState" + e.getSQLState());
					System.out.println("Message"+ e.getMessage());
					System.out.println("Vendor"+ e.getErrorCode());

					e = e.getNextException();
					System.out.println("");

				}
			}
			catch (java.lang.Exception e){

				System.out.println("Exception" + e);

				e.printStackTrace();

			}
	       return done;
	   }
                             }
