package ru.rdtex.mvd.weapon.model.vo.read.client;

import oracle.jbo.client.remote.ViewUsageImpl;

import ru.rdtex.mvd.weapon.model.vo.read.common.VSuperDocView;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Aug 08 18:31:25 MSD 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VSuperDocViewClient extends ViewUsageImpl implements VSuperDocView {
    /**
     * This is the default constructor (do not remove).
     */
    public VSuperDocViewClient() {
    }

    public void deleteSelectedRows() {
        Object _ret =
            getApplicationModuleProxy().riInvokeExportedMethod(this,"deleteSelectedRows",null,null);
        return;
    }
}
