package fr.eni.tebd.dal;



public abstract class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO() {
		
		return new UtilisateurDaoJdbcImpl();
	}
	

}
