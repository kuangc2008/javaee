import databases.CstCustomerEntity;
import databases.CstLinkmanEntity;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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


        final Session session = getSession();
        Transaction transaction = session.beginTransaction();

        CstCustomerEntity cce = new CstCustomerEntity();
        cce.setCustName("fsaf");
        cce.setCustLevel("fdsfsf");
        cce.setCustIndustry("fdsfsf");
        cce.setCustMobile("fdsfsf");
        cce.setCustPhone("fdsfsf");
        cce.setCustSource("fdsfsf");

        session.save(cce);

        Set<CstLinkmanEntity> aa= new HashSet<CstLinkmanEntity>();

        CstLinkmanEntity cstLinkmanEntity = new CstLinkmanEntity();
        cstLinkmanEntity.setLkmEmail("fdsaf");
        cstLinkmanEntity.setLkmGender("fdsaf");
        cstLinkmanEntity.setLkmMemo("fdsaf");
        cstLinkmanEntity.setLkmMobile("fdsaf");
        cstLinkmanEntity.setLkmName("fdsaf");
        cstLinkmanEntity.setCstCustomerByLkmCustId(cce);
        aa.add(cstLinkmanEntity);

        session.save(cstLinkmanEntity);


        cstLinkmanEntity = new CstLinkmanEntity();
        cstLinkmanEntity.setLkmEmail("sfafsfdfsafsf");
        cstLinkmanEntity.setLkmGender("safsdafsaf");
        cstLinkmanEntity.setLkmMemo("sfafdsaf");
        cstLinkmanEntity.setLkmMobile("safdadfd");
        cstLinkmanEntity.setLkmName("sdafadfsf");
        cstLinkmanEntity.setCstCustomerByLkmCustId(cce);
        aa.add(cstLinkmanEntity);
        session.save(cstLinkmanEntity);


        cce.setCstLinkmenByCustId(aa);








        transaction.commit();


    }
}