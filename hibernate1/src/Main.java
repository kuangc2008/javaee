import databases.UserEntity;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }




//        final Session session2 = getSession();
//        Transaction transaction = session2.beginTransaction();
//        try {
//            UserEntity aa = new UserEntity();
//            aa.setName("sunhuihui");
//            aa.setPassword("love forever");
//            session2.save(aa);
//            transaction.commit();
//        } finally {
//            session2.close();
//        }



        final Session session = getSession();
        UserEntity userEntity = session.get(UserEntity.class, 19);
        session.close();

        System.out.println("userEn-->" + userEntity);


    }
}