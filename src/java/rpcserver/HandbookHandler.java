package rpcserver;

import org.apache.thrift.TException;
import same.Dao;
import same.HandbookService;

import java.util.List;

class HandbookHandler implements HandbookService.Iface {
    @Override
    public String changeBody(String title, String newBody) throws TException {
        return null;
    }

    @Override
    public String deleteReference(String title) throws TException {
        return null;
    }

    @Override
    public String add(String title, String body) throws TException {
        return null;
    }

    @Override
    public List<String> takeTitles() throws TException {
        return Dao.getINSTANCE().takeTitles();
    }

    @Override
    public String takeBody(String title) throws TException {
        return Dao.getINSTANCE().takeBody(title);
    }
}
