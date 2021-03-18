package net.france.operantic.microservices.codingame;

/**
 * 
 * @author operantic
 *
 * Mettez à jour le code en appliquant les règles suivantes : Si une exception est levée par s.execute() 
 * alors appeler c.rollback() et propager l'exception, sinon appeler c.commit() 
 * Dans tous les cas, c.close() doit être appelée avant de quitter la méthode a(Service s, Connection c)
 *
 * A Corriger L'exception est propagée
 *
 */
public class TestException {

	/**
	* Executes the service with the given connection.
	*/
	void a(Service s, Connection c) {
	// update this code
	   try{
	      s.setConnection(c);
	      s.execute();
	      c.commit();
		} catch(Exception e){
		  c.rollback();
		} finally{
		   c.close();
		}
	  }
	}

	
	interface Service {
	  void execute() throws Exception;
	  void setConnection(Connection c);
	}

	
	interface Connection {
	   void commit();
	   void rollback();
	   void close();
	}
