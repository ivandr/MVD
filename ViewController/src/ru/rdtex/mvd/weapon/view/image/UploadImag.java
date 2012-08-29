package ru.rdtex.mvd.weapon.view.image;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.sql.SQLException;

import java.util.ArrayList;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.BlobDomain;

import org.apache.myfaces.trinidad.model.UploadedFile;
import oracle.jbo.domain.Number;

import ru.rdtex.mvd.weapon.view.backing.Main;

public class UploadImag {
    public UploadImag() {
        super();
    }

    private UploadedFile _file;

    public UploadedFile getFile() {
        return _file;
    }

    public void setFile(UploadedFile file) {
        _file = file;
    }

    public String uploadImage() {
        UploadedFile myfile = this.getFile();
        Row row = getImageRow();
        row.setAttribute("Photo", createBlobDomain(myfile));
        Main.save_action();
        return null;
    }
    
    public void deleteImage() {
        Row row = getImageRow();
        row.remove();
        Main.save_action();
    }
    
    private Row getImageRow() {
        BindingContext bindingctx = BindingContext.getCurrent();
        BindingContainer bindings = bindingctx.getCurrentBindingsEntry();
        DCBindingContainer bindingsImpl = (DCBindingContainer)bindings;
        //DCIteratorBinding iter1 = bindingsImpl.findIteratorBinding("EntPersonsView1Iterator");
        DCIteratorBinding iter2 = bindingsImpl.findIteratorBinding("EntPhotoView2Iterator");
        //Row row1 = iter1.getCurrentRow();
        //String id = row1.getAttribute("Id").toString();
        ViewObject vo = iter2.getViewObject();
        Row[] rows = vo.getAllRowsInRange();
        Row row2 = null;
        for (Row r : rows) {
            row2 = r;
        }
        //System.out.println("row2 = " + row2);
        if (row2 == null) {
            row2 = vo.createRow();
            //row2.setAttribute("EpId", id);
        }
        return row2;
    }

    private BlobDomain createBlobDomain(UploadedFile file) {

        InputStream in = null;
        BlobDomain blobDomain = null;
        OutputStream out = null;

        try {
            in = file.getInputStream();

            blobDomain = new BlobDomain();
            out = blobDomain.getBinaryOutputStream();
            byte[] buffer = new byte[8192];
            int bytesRead = 0;

            while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }

        return blobDomain;
    }

}
