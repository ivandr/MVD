package ru.rdtex.mvd.weapon.model.am;

import java.sql.CallableStatement;

import java.sql.SQLException;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;


import oracle.jbo.server.ViewObjectImpl;

import ru.rdtex.mvd.weapon.model.am.common.AppModule;
import ru.rdtex.mvd.weapon.model.vo.DocDocumentsViewImpl;
import ru.rdtex.mvd.weapon.model.vo.DocPermissionsViewImpl;
import ru.rdtex.mvd.weapon.model.vo.DocRequestsViewImpl;
import ru.rdtex.mvd.weapon.model.vo.EntAddressesViewImpl;
import ru.rdtex.mvd.weapon.model.vo.lov.DocDocumentsRelationsViewImpl;
import ru.rdtex.mvd.weapon.model.vo.RegionDeptViewImpl;
import ru.rdtex.mvd.weapon.model.vo.read.VSuperDocViewImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jun 25 13:20:12 MSD 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleImpl extends ApplicationModuleImpl implements AppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleImpl() {
        super();
    }

    public void createRow(String ViewObjectName) {        
        Row newRow = findViewObject(ViewObjectName).createRow();
        newRow.setNewRowState(Row.STATUS_INITIALIZED);
        //get instance of the above created view object
        ViewObjectImpl vo = (ViewObjectImpl)findViewObject(ViewObjectName);
        // to insert row at the end of the table
        //vo.insertRowAtRangeIndex(vo.getRangeSize() - 1, newRow);
        //System.out.println(getCountryView1().getCurrentRowIndex());
        vo.insertRow(newRow);
    }
        
    public void deleteSelectedRows(String ViewObjectName) {
        ViewObjectImpl vo = (ViewObjectImpl)findViewObject(ViewObjectName);
        //create a second row set to not impact the row set
        //used in ADF
        RowSet duplicateRowSet = vo.createRowSet("duplicateRowSet");
        //set rowset to first row to avoid "attempt to access
        //dead row" exception
        duplicateRowSet.first();
        //get the current row of the table to set it back after
        //re-executing the VO
        Row currentRow = vo.getCurrentRow();
        boolean currentRowDeleted = false;
        //get all rows that have the transoent attribute
        //"MarkForDelete" set to true
        Row[] rowsToDelete =
            duplicateRowSet.getFilteredRows("DeleteRow", true);
        
        /*Row r = duplicateRowSet.first();
        System.out.println("DeleteRow = " + r.getAttribute("DeleteRow")); 
        //System.out.println("row = " + r.getAttribute("test")); 
        while(duplicateRowSet.hasNext()) {
            r = duplicateRowSet.next();
            System.out.println("DeleteRow = " + r.getAttribute("DeleteRow")); 
            //System.out.println("row = " + r.getAttribute("test")); 
        }*/
        
        if (rowsToDelete.length > 0) {
            //only run throizgh this code if there is something to
            //delete
            for (Row rw : rowsToDelete) {
                //if row is ts marked as the current in VO, set
                //boolean flag
                if (rw.getKey().equals(currentRow.getKey())) {
                    currentRowDeleted = true;
                }
                //remove row - don't yet commit
                rw.remove();
            }
            //re-execute VO
            vo.executeQuery();
            //reset current row if it hasn't been deleted
            if (!currentRowDeleted) {
                vo.setCurrentRow(currentRow);
            }
            
            //duplicateRowSet.closeRowSet();
        }
        duplicateRowSet.closeRowSet();
    }
    /**
     * Container's getter for CountryView1.
     * @return CountryView1
     */
    public ViewObjectImpl getCountryView1() {
        return (ViewObjectImpl)findViewObject("CountryView1");
    }
    
    /**
     * Container's getter for EntPersonsView1.
     * @return EntPersonsView1
     */
    public ViewObjectImpl getEntPersonsView1() {
        return (ViewObjectImpl)findViewObject("EntPersonsView1");
    }

    /**
     * Container's getter for ObjObjectsView1.
     * @return ObjObjectsView1
     */
    public ViewObjectImpl getObjObjectsView1() {
        return (ViewObjectImpl)findViewObject("ObjObjectsView1");
    }

    /**
     * Container's getter for TypeDocView1.
     * @return TypeDocView1
     */
    public ViewObjectImpl getTypeDocView1() {
        return (ViewObjectImpl)findViewObject("TypeDocView1");
    }

    /**
     * Container's getter for TypePersonView1.
     * @return TypePersonView1
     */
    public ViewObjectImpl getTypePersonView1() {
        return (ViewObjectImpl)findViewObject("TypePersonView1");
    }

    /**
     * Container's getter for EntPersonsView2.
     * @return EntPersonsView2
     */
    public ViewObjectImpl getEntPersonsView2() {
        return (ViewObjectImpl)findViewObject("EntPersonsView2");
    }

    /**
     * Container's getter for EntPersonsView3.
     * @return EntPersonsView3
     */
    public ViewObjectImpl getEntPersonsView3() {
        return (ViewObjectImpl)findViewObject("EntPersonsView3");
    }

    /**
     * Container's getter for ObjObjectsView2.
     * @return ObjObjectsView2
     */
    public ViewObjectImpl getObjObjectsView2() {
        return (ViewObjectImpl)findViewObject("ObjObjectsView2");
    }

    /**
     * Container's getter for EntPersonsView4.
     * @return EntPersonsView4
     */
    public ViewObjectImpl getEntPersonsView4() {
        return (ViewObjectImpl)findViewObject("EntPersonsView4");
    }

    /**
     * Container's getter for EntPersonsView5.
     * @return EntPersonsView5
     */
    public ViewObjectImpl getEntPersonsView5() {
        return (ViewObjectImpl)findViewObject("EntPersonsView5");
    }

    /**
     * Container's getter for EntPersonsView6.
     * @return EntPersonsView6
     */
    public ViewObjectImpl getEntPersonsView6() {
        return (ViewObjectImpl)findViewObject("EntPersonsView6");
    }

    /**
     * Container's getter for EpEpFkLink1.
     * @return EpEpFkLink1
     */
    public ViewLinkImpl getEpEpFkLink1() {
        return (ViewLinkImpl)findViewLink("EpEpFkLink1");
    }

    /**
     * Container's getter for EpCountryFkLink1.
     * @return EpCountryFkLink1
     */
    public ViewLinkImpl getEpCountryFkLink1() {
        return (ViewLinkImpl)findViewLink("EpCountryFkLink1");
    }

    /**
     * Container's getter for OoOoFkLink1.
     * @return OoOoFkLink1
     */
    public ViewLinkImpl getOoOoFkLink1() {
        return (ViewLinkImpl)findViewLink("OoOoFkLink1");
    }

    /**
     * Container's getter for EpObjFkLink1.
     * @return EpObjFkLink1
     */
    public ViewLinkImpl getEpObjFkLink1() {
        return (ViewLinkImpl)findViewLink("EpObjFkLink1");
    }

    /**
     * Container's getter for EpTypedocFkLink1.
     * @return EpTypedocFkLink1
     */
    public ViewLinkImpl getEpTypedocFkLink1() {
        return (ViewLinkImpl)findViewLink("EpTypedocFkLink1");
    }

    /**
     * Container's getter for EpPtypeFkLink1.
     * @return EpPtypeFkLink1
     */
    public ViewLinkImpl getEpPtypeFkLink1() {
        return (ViewLinkImpl)findViewLink("EpPtypeFkLink1");
    }
    public String sayHello(){
  CallableStatement cs=  this.getDBTransaction().createCallableStatement("",0);
      
     return    "";
   } 
    public  void    PUT_IN_ARCHIVE(String stmt) {
        CallableStatement st = null;
        try {
            st =
          getDBTransaction().createCallableStatement(
                        "begin  " + stmt + ";end;", 0);

            st.execute();
        } catch (SQLException e) {
            throw new JboException(e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                }
            }
        }

      }

    /**
     * Container's getter for YesNo10_1.
     * @return YesNo10_1
     */
    public ViewObjectImpl getYesNo10_1() {
        return (ViewObjectImpl)findViewObject("YesNo10_1");
    }

    /**
     * Container's getter for RegionView1.
     * @return RegionView1
     */
    public ViewObjectImpl getRegionView1() {
        return (ViewObjectImpl)findViewObject("RegionView1");
    }

    /**
     * Container's getter for RegionView1_1.
     * @return RegionView1_1
     */
    public ViewObjectImpl getRegionView1_1() {
        return (ViewObjectImpl)findViewObject("RegionView1_1");
    }

    /**
     * Container's getter for TypeLicenceView1.
     * @return TypeLicenceView1
     */
    public ViewObjectImpl getTypeLicenceView1() {
        return (ViewObjectImpl)findViewObject("TypeLicenceView1");
    }

    /**
     * Container's getter for FisUr1.
     * @return FisUr1
     */
    public ViewObjectImpl getFisUr1() {
        return (ViewObjectImpl)findViewObject("FisUr1");
    }

    /**
     * Container's getter for TypeBlank1.
     * @return TypeBlank1
     */
    public ViewObjectImpl getTypeBlank1() {
        return (ViewObjectImpl)findViewObject("TypeBlank1");
    }

    /**
     * Container's getter for RewardOrganView1.
     * @return RewardOrganView1
     */
    public ViewObjectImpl getRewardOrganView1() {
        return (ViewObjectImpl)findViewObject("RewardOrganView1");
    }

    /**
     * Container's getter for ProtectedObjectKindView1.
     * @return ProtectedObjectKindView1
     */
    public ViewObjectImpl getProtectedObjectKindView1() {
        return (ViewObjectImpl)findViewObject("ProtectedObjectKindView1");
    }

    /**
     * Container's getter for EntAddressesView1.
     * @return EntAddressesView1
     */
    public ViewObjectImpl getEntAddressesView1() {
        return (ViewObjectImpl)findViewObject("EntAddressesView1");
    }

    /**
     * Container's getter for EntAddressesView2.
     * @return EntAddressesView2
     */
    public EntAddressesViewImpl getEntAddressesView2() {
        return (EntAddressesViewImpl)findViewObject("EntAddressesView2");
    }

    /**
     * Container's getter for EntPerson_EntAddresses_Link1.
     * @return EntPerson_EntAddresses_Link1
     */
    public ViewLinkImpl getEntPerson_EntAddresses_Link1() {
        return (ViewLinkImpl)findViewLink("EntPerson_EntAddresses_Link1");
    }

    /**
     * Container's getter for TypeAddressesView1.
     * @return TypeAddressesView1
     */
    public ViewObjectImpl getTypeAddressesView1() {
        return (ViewObjectImpl)findViewObject("TypeAddressesView1");
    }

    /**
     * Container's getter for CalibrView1.
     * @return CalibrView1
     */
    public ViewObjectImpl getCalibrView1() {
        return (ViewObjectImpl)findViewObject("CalibrView1");
    }

    /**
     * Container's getter for CodeGunView1.
     * @return CodeGunView1
     */
    public ViewObjectImpl getCodeGunView1() {
        return (ViewObjectImpl)findViewObject("CodeGunView1");
    }

    /**
     * Container's getter for KindGunView1.
     * @return KindGunView1
     */
    public ViewObjectImpl getKindGunView1() {
        return (ViewObjectImpl)findViewObject("KindGunView1");
    }

    /**
     * Container's getter for ModelGunView1.
     * @return ModelGunView1
     */
    public ViewObjectImpl getModelGunView1() {
        return (ViewObjectImpl)findViewObject("ModelGunView1");
    }

    /**
     * Container's getter for TypeGunView1.
     * @return TypeGunView1
     */
    public ViewObjectImpl getTypeGunView1() {
        return (ViewObjectImpl)findViewObject("TypeGunView1");
    }

    /**
     * Container's getter for CodeGunView2.
     * @return CodeGunView2
     */
    public ViewObjectImpl getCodeGunView2() {
        return (ViewObjectImpl)findViewObject("CodeGunView2");
    }

    /**
     * Container's getter for CodeGunView3.
     * @return CodeGunView3
     */
    public ViewObjectImpl getCodeGunView3() {
        return (ViewObjectImpl)findViewObject("CodeGunView3");
    }

    /**
     * Container's getter for CodeGunView4.
     * @return CodeGunView4
     */
    public ViewObjectImpl getCodeGunView4() {
        return (ViewObjectImpl)findViewObject("CodeGunView4");
    }

    /**
     * Container's getter for CodeGunView5.
     * @return CodeGunView5
     */
    public ViewObjectImpl getCodeGunView5() {
        return (ViewObjectImpl)findViewObject("CodeGunView5");
    }

    /**
     * Container's getter for CodeGunView6.
     * @return CodeGunView6
     */
    public ViewObjectImpl getCodeGunView6() {
        return (ViewObjectImpl)findViewObject("CodeGunView6");
    }

    /**
     * Container's getter for CodeGunView7.
     * @return CodeGunView7
     */
    public ViewObjectImpl getCodeGunView7() {
        return (ViewObjectImpl)findViewObject("CodeGunView7");
    }

    /**
     * Container's getter for Codegun1Kindgun1FkLink1.
     * @return Codegun1Kindgun1FkLink1
     */
    public ViewLinkImpl getCodegun1Kindgun1FkLink1() {
        return (ViewLinkImpl)findViewLink("Codegun1Kindgun1FkLink1");
    }

    /**
     * Container's getter for Codegun1TypeGun1FkLink1.
     * @return Codegun1TypeGun1FkLink1
     */
    public ViewLinkImpl getCodegun1TypeGun1FkLink1() {
        return (ViewLinkImpl)findViewLink("Codegun1TypeGun1FkLink1");
    }

    /**
     * Container's getter for Codegun1Calibr1FkLink1.
     * @return Codegun1Calibr1FkLink1
     */
    public ViewLinkImpl getCodegun1Calibr1FkLink1() {
        return (ViewLinkImpl)findViewLink("Codegun1Calibr1FkLink1");
    }

    /**
     * Container's getter for Codegun1Calibr14FkLink1.
     * @return Codegun1Calibr14FkLink1
     */
    public ViewLinkImpl getCodegun1Calibr14FkLink1() {
        return (ViewLinkImpl)findViewLink("Codegun1Calibr14FkLink1");
    }

    /**
     * Container's getter for Codegun1Calibr13FkLink1.
     * @return Codegun1Calibr13FkLink1
     */
    public ViewLinkImpl getCodegun1Calibr13FkLink1() {
        return (ViewLinkImpl)findViewLink("Codegun1Calibr13FkLink1");
    }

    /**
     * Container's getter for Codegun1Calibr12FkLink1.
     * @return Codegun1Calibr12FkLink1
     */
    public ViewLinkImpl getCodegun1Calibr12FkLink1() {
        return (ViewLinkImpl)findViewLink("Codegun1Calibr12FkLink1");
    }

    /**
     * Container's getter for DocRelationsView1.
     * @return DocRelationsView1
     */
    public ViewObjectImpl getDocRelationsView1() {
        return (ViewObjectImpl)findViewObject("DocRelationsView1");
    }

    /**
     * Container's getter for GunGunsView1.
     * @return GunGunsView1
     */
    public ViewObjectImpl getGunGunsView1() {
        return (ViewObjectImpl)findViewObject("GunGunsView1");
    }

    /**
     * Container's getter for DocRelationsView2.
     * @return DocRelationsView2
     */
    public ViewObjectImpl getDocRelationsView2() {
        return (ViewObjectImpl)findViewObject("DocRelationsView2");
    }

    /**
     * Container's getter for DrlGunFkLink1.
     * @return DrlGunFkLink1
     */
    public ViewLinkImpl getDrlGunFkLink1() {
        return (ViewLinkImpl)findViewLink("DrlGunFkLink1");
    }

    /**
     * Container's getter for DocRelationsView3.
     * @return DocRelationsView3
     */
    public ViewObjectImpl getDocRelationsView3() {
        return (ViewObjectImpl)findViewObject("DocRelationsView3");
    }

    /**
     * Container's getter for EntPerson_DocRelations_Link1.
     * @return EntPerson_DocRelations_Link1
     */
    public ViewLinkImpl getEntPerson_DocRelations_Link1() {
        return (ViewLinkImpl)findViewLink("EntPerson_DocRelations_Link1");
    }

    /**
     * Container's getter for DocDocumentsDocRelationsView1.
     * @return DocDocumentsDocRelationsView1
     */
    public ViewObjectImpl getDocDocumentsDocRelationsView1() {
        return (ViewObjectImpl)findViewObject("DocDocumentsDocRelationsView1");
    }

    /**
     * Container's getter for DocDocumentsView1.
     * @return DocDocumentsView1
     */
    public ViewObjectImpl getDocDocumentsView1() {
        return (ViewObjectImpl)findViewObject("DocDocumentsView1");
    }

    /**
     * Container's getter for DocPermissionsView1.
     * @return DocPermissionsView1
     */
    public ViewObjectImpl getDocPermissionsView1() {
        return (ViewObjectImpl)findViewObject("DocPermissionsView1");
    }

    /**
     * Container's getter for DocDocumentsView2.
     * @return DocDocumentsView2
     */
    public ViewObjectImpl getDocDocumentsView2() {
        return (ViewObjectImpl)findViewObject("DocDocumentsView2");
    }

    /**
     * Container's getter for DocDocumentsDocRelationsView2.
     * @return DocDocumentsDocRelationsView2
     */
    public ViewObjectImpl getDocDocumentsDocRelationsView2() {
        return (ViewObjectImpl)findViewObject("DocDocumentsDocRelationsView2");
    }

    /**
     * Container's getter for DocPermissionsView2.
     * @return DocPermissionsView2
     */
    public ViewObjectImpl getDocPermissionsView2() {
        return (ViewObjectImpl)findViewObject("DocPermissionsView2");
    }

    /**
     * Container's getter for DdcDdcFkLink1.
     * @return DdcDdcFkLink1
     */
    public ViewLinkImpl getDdcDdcFkLink1() {
        return (ViewLinkImpl)findViewLink("DdcDdcFkLink1");
    }

    /**
     * Container's getter for DdcDrlDdcFkLink1.
     * @return DdcDrlDdcFkLink1
     */
    public ViewLinkImpl getDdcDrlDdcFkLink1() {
        return (ViewLinkImpl)findViewLink("DdcDrlDdcFkLink1");
    }

    /**
     * Container's getter for DprDdcFkLink1.
     * @return DprDdcFkLink1
     */
    public ViewLinkImpl getDprDdcFkLink1() {
        return (ViewLinkImpl)findViewLink("DprDdcFkLink1");
    }

    /**
     * Container's getter for RPersonGunsView1.
     * @return RPersonGunsView1
     */
    public ViewObjectImpl getRPersonGunsView1() {
        return (ViewObjectImpl)findViewObject("RPersonGunsView1");
    }

    /**
     * Container's getter for RGunDocumentsView1.
     * @return RGunDocumentsView1
     */
    public ViewObjectImpl getRGunDocumentsView1() {
        return (ViewObjectImpl)findViewObject("RGunDocumentsView1");
    }

    /**
     * Container's getter for RGunDocumentsView2.
     * @return RGunDocumentsView2
     */
    public ViewObjectImpl getRGunDocumentsView2() {
        return (ViewObjectImpl)findViewObject("RGunDocumentsView2");
    }

    /**
     * Container's getter for RPersonGuns_RGunDocuments_Link1.
     * @return RPersonGuns_RGunDocuments_Link1
     */
    public ViewLinkImpl getRPersonGuns_RGunDocuments_Link1() {
        return (ViewLinkImpl)findViewLink("RPersonGuns_RGunDocuments_Link1");
    }

    /**
     * Container's getter for RPersonGunsView2.
     * @return RPersonGunsView2
     */
    public ViewObjectImpl getRPersonGunsView2() {
        return (ViewObjectImpl)findViewObject("RPersonGunsView2");
    }

    /**
     * Container's getter for EntPersons_RPersonGuns_Link1.
     * @return EntPersons_RPersonGuns_Link1
     */
    public ViewLinkImpl getEntPersons_RPersonGuns_Link1() {
        return (ViewLinkImpl)findViewLink("EntPersons_RPersonGuns_Link1");
    }

    /**
     * Container's getter for AcsUsersView1.
     * @return AcsUsersView1
     */
    public ViewObjectImpl getAcsUsersView1() {
        return (ViewObjectImpl)findViewObject("AcsUsersView1");
    }


    /**
     * Container's getter for REntPersonsView1.
     * @return REntPersonsView1
     */
    public ViewObjectImpl getREntPersonsView1() {
        return (ViewObjectImpl)findViewObject("REntPersonsView1");
    }

    /**
     * Container's getter for AdmDistrictView1.
     * @return AdmDistrictView1
     */
    public ViewObjectImpl getAdmDistrictView1() {
        return (ViewObjectImpl)findViewObject("AdmDistrictView1");
    }

    /**
     * Container's getter for PoliceDeptView1.
     * @return PoliceDeptView1
     */
    public ViewObjectImpl getPoliceDeptView1() {
        return (ViewObjectImpl)findViewObject("PoliceDeptView1");
    }

    /**
     * Container's getter for RegionDeptView1.
     * @return RegionDeptView1
     */
    public ViewObjectImpl getRegionDeptView1() {
        return (ViewObjectImpl)findViewObject("RegionDeptView1");
    }

    /**
     * Container's getter for StreetsView1.
     * @return StreetsView1
     */
    public ViewObjectImpl getStreetsView1() {
        return (ViewObjectImpl)findViewObject("StreetsView1");
    }

    /**
     * Container's getter for TownVillageView1.
     * @return TownVillageView1
     */
    public ViewObjectImpl getTownVillageView1() {
        return (ViewObjectImpl)findViewObject("TownVillageView1");
    }

    /**
     * Container's getter for TownVillageView2.
     * @return TownVillageView2
     */
    public ViewObjectImpl getTownVillageView2() {
        return (ViewObjectImpl)findViewObject("TownVillageView2");
    }

    /**
     * Container's getter for Town1Regiond1FkLink1.
     * @return Town1Regiond1FkLink1
     */
    public ViewLinkImpl getTown1Regiond1FkLink1() {
        return (ViewLinkImpl)findViewLink("Town1Regiond1FkLink1");
    }

    /**
     * Container's getter for MunDistrictView1.
     * @return MunDistrictView1
     */
    public ViewObjectImpl getMunDistrictView1() {
        return (ViewObjectImpl)findViewObject("MunDistrictView1");
    }

    /**
     * Container's getter for RegionDeptView2.
     * @return RegionDeptView2
     */
    public RegionDeptViewImpl getRegionDeptView2() {
        return (RegionDeptViewImpl)findViewObject("RegionDeptView2");
    }

    /**
     * Container's getter for Regin_ReginDept_Link1.
     * @return Regin_ReginDept_Link1
     */
    public ViewLinkImpl getRegin_ReginDept_Link1() {
        return (ViewLinkImpl)findViewLink("Regin_ReginDept_Link1");
    }

    /**
     * Container's getter for StreetsView2.
     * @return StreetsView2
     */
    public ViewObjectImpl getStreetsView2() {
        return (ViewObjectImpl)findViewObject("StreetsView2");
    }

    /**
     * Container's getter for TownVillage_Streets_Link1.
     * @return TownVillage_Streets_Link1
     */
    public ViewLinkImpl getTownVillage_Streets_Link1() {
        return (ViewLinkImpl)findViewLink("TownVillage_Streets_Link1");
    }

    /**
     * Container's getter for AdmDistrictView2.
     * @return AdmDistrictView2
     */
    public ViewObjectImpl getAdmDistrictView2() {
        return (ViewObjectImpl)findViewObject("AdmDistrictView2");
    }

    /**
     * Container's getter for TownVillage_AdmDistrict_Link1.
     * @return TownVillage_AdmDistrict_Link1
     */
    public ViewLinkImpl getTownVillage_AdmDistrict_Link1() {
        return (ViewLinkImpl)findViewLink("TownVillage_AdmDistrict_Link1");
    }

    /**
     * Container's getter for MunDistrictView2.
     * @return MunDistrictView2
     */
    public ViewObjectImpl getMunDistrictView2() {
        return (ViewObjectImpl)findViewObject("MunDistrictView2");
    }

    /**
     * Container's getter for AdmDistrict_MunDistrict_View1.
     * @return AdmDistrict_MunDistrict_View1
     */
    public ViewLinkImpl getAdmDistrict_MunDistrict_View1() {
        return (ViewLinkImpl)findViewLink("AdmDistrict_MunDistrict_View1");
    }

    /**
     * Container's getter for PoliceDeptView2.
     * @return PoliceDeptView2
     */
    public ViewObjectImpl getPoliceDeptView2() {
        return (ViewObjectImpl)findViewObject("PoliceDeptView2");
    }

    /**
     * Container's getter for MunDistrict_PoliceDept_Link1.
     * @return MunDistrict_PoliceDept_Link1
     */
    public ViewLinkImpl getMunDistrict_PoliceDept_Link1() {
        return (ViewLinkImpl)findViewLink("MunDistrict_PoliceDept_Link1");
    }

    /**
     * Container's getter for EntPersonsRovdView1.
     * @return EntPersonsRovdView1
     */
    public ViewObjectImpl getEntPersonsRovdView1() {
        return (ViewObjectImpl)findViewObject("EntPersonsRovdView1");
    }

    /**
     * Container's getter for DepartmentsView1.
     * @return DepartmentsView1
     */
    public ViewObjectImpl getDepartmentsView1() {
        return (ViewObjectImpl)findViewObject("DepartmentsView1");
    }

    /**
     * Container's getter for EntPersonsRovdView2.
     * @return EntPersonsRovdView2
     */
    public ViewObjectImpl getEntPersonsRovdView2() {
        return (ViewObjectImpl)findViewObject("EntPersonsRovdView2");
    }

    /**
     * Container's getter for EntPersonRovd_EntPerson_Link1.
     * @return EntPersonRovd_EntPerson_Link1
     */
    public ViewLinkImpl getEntPersonRovd_EntPerson_Link1() {
        return (ViewLinkImpl)findViewLink("EntPersonRovd_EntPerson_Link1");
    }

    /**
     * Container's getter for RovdStatusView1.
     * @return RovdStatusView1
     */
    public ViewObjectImpl getRovdStatusView1() {
        return (ViewObjectImpl)findViewObject("RovdStatusView1");
    }

    /**
     * Container's getter for EntPhotoView1.
     * @return EntPhotoView1
     */
    public ViewObjectImpl getEntPhotoView1() {
        return (ViewObjectImpl)findViewObject("EntPhotoView1");
    }

    /**
     * Container's getter for EntPhotoView2.
     * @return EntPhotoView2
     */
    public ViewObjectImpl getEntPhotoView2() {
        return (ViewObjectImpl)findViewObject("EntPhotoView2");
    }

    /**
     * Container's getter for EntPersons_EntPhoto_Link1.
     * @return EntPersons_EntPhoto_Link1
     */
    public ViewLinkImpl getEntPersons_EntPhoto_Link1() {
        return (ViewLinkImpl)findViewLink("EntPersons_EntPhoto_Link1");
    }

    /**
     * Container's getter for VSuperDocView1.
     * @return VSuperDocView1
     */
    public VSuperDocViewImpl getVSuperDocView1() {
        return (VSuperDocViewImpl)findViewObject("VSuperDocView1");
    }

    /**
     * Container's getter for VSuperDocView2.
     * @return VSuperDocView2
     */
    public VSuperDocViewImpl getVSuperDocView2() {
        return (VSuperDocViewImpl)findViewObject("VSuperDocView2");
    }

    /**
     * Container's getter for EntPersons_VSuperDoc_Link1.
     * @return EntPersons_VSuperDoc_Link1
     */
    public ViewLinkImpl getEntPersons_VSuperDoc_Link1() {
        return (ViewLinkImpl)findViewLink("EntPersons_VSuperDoc_Link1");
    }

    /**
     * Container's getter for DocRequestsView1.
     * @return DocRequestsView1
     */
    public ViewObjectImpl getDocRequestsView1() {
        return (ViewObjectImpl)findViewObject("DocRequestsView1");
    }

    /**
     * Container's getter for CgRefCodesView1.
     * @return CgRefCodesView1
     */
    public ViewObjectImpl getCgRefCodesView1() {
        return (ViewObjectImpl)findViewObject("CgRefCodesView1");
    }

    /**
     * Container's getter for DocDocumentsView3.
     * @return DocDocumentsView3
     */
    public ViewObjectImpl getDocDocumentsView3() {
        return (ViewObjectImpl)findViewObject("DocDocumentsView3");
    }

    /**
     * Container's getter for VSuperDoc_DocDocuments_Link1.
     * @return VSuperDoc_DocDocuments_Link1
     */
    public ViewLinkImpl getVSuperDoc_DocDocuments_Link1() {
        return (ViewLinkImpl)findViewLink("VSuperDoc_DocDocuments_Link1");
    }

    /**
     * Container's getter for DocRequestsView2.
     * @return DocRequestsView2
     */
    public ViewObjectImpl getDocRequestsView2() {
        return (ViewObjectImpl)findViewObject("DocRequestsView2");
    }

    /**
     * Container's getter for VSuperDoc_DocRequests_Link1.
     * @return VSuperDoc_DocRequests_Link1
     */
    public ViewLinkImpl getVSuperDoc_DocRequests_Link1() {
        return (ViewLinkImpl)findViewLink("VSuperDoc_DocRequests_Link1");
    }

    /**
     * Container's getter for DocDocumentsView4.
     * @return DocDocumentsView4
     */
    public ViewObjectImpl getDocDocumentsView4() {
        return (ViewObjectImpl)findViewObject("DocDocumentsView4");
    }

    /**
     * Container's getter for VSuperDoc_DocDocuments_Link2.
     * @return VSuperDoc_DocDocuments_Link2
     */
    public ViewLinkImpl getVSuperDoc_DocDocuments_Link2() {
        return (ViewLinkImpl)findViewLink("VSuperDoc_DocDocuments_Link2");
    }

    /**
     * Container's getter for DocRequestsView3.
     * @return DocRequestsView3
     */
    public ViewObjectImpl getDocRequestsView3() {
        return (ViewObjectImpl)findViewObject("DocRequestsView3");
    }

    /**
     * Container's getter for VSuperDoc_DocRequests_Link2.
     * @return VSuperDoc_DocRequests_Link2
     */
    public ViewLinkImpl getVSuperDoc_DocRequests_Link2() {
        return (ViewLinkImpl)findViewLink("VSuperDoc_DocRequests_Link2");
    }

    /**
     * Container's getter for TypePermisionView1.
     * @return TypePermisionView1
     */
    public ViewObjectImpl getTypePermisionView1() {
        return (ViewObjectImpl)findViewObject("TypePermisionView1");
    }

    /**
     * Container's getter for HeadsView1.
     * @return HeadsView1
     */
    public ViewObjectImpl getHeadsView1() {
        return (ViewObjectImpl)findViewObject("HeadsView1");
    }

    /**
     * Container's getter for StatusLicenceView1.
     * @return StatusLicenceView1
     */
    public ViewObjectImpl getStatusLicenceView1() {
        return (ViewObjectImpl)findViewObject("StatusLicenceView1");
    }

    /**
     * Container's getter for DocDocumentsView5.
     * @return DocDocumentsView5
     */
    public ViewObjectImpl getDocDocumentsView5() {
        return (ViewObjectImpl)findViewObject("DocDocumentsView5");
    }

    /**
     * Container's getter for VSuperDoc_DocDocuments_License_Link1.
     * @return VSuperDoc_DocDocuments_License_Link1
     */
    public ViewLinkImpl getVSuperDoc_DocDocuments_License_Link1() {
        return (ViewLinkImpl)findViewLink("VSuperDoc_DocDocuments_License_Link1");
    }

    /**
     * Container's getter for DocPermissionsView3.
     * @return DocPermissionsView3
     */
    public DocPermissionsViewImpl getDocPermissionsView3() {
        return (DocPermissionsViewImpl)findViewObject("DocPermissionsView3");
    }

    /**
     * Container's getter for VSuperDoc_DocPermissions_License_Link1.
     * @return VSuperDoc_DocPermissions_License_Link1
     */
    public ViewLinkImpl getVSuperDoc_DocPermissions_License_Link1() {
        return (ViewLinkImpl)findViewLink("VSuperDoc_DocPermissions_License_Link1");
    }

    /**
     * Container's getter for DocPermissionsView4.
     * @return DocPermissionsView4
     */
    public DocPermissionsViewImpl getDocPermissionsView4() {
        return (DocPermissionsViewImpl)findViewObject("DocPermissionsView4");
    }

    /**
     * Container's getter for VSuperDoc_DocPermissions_License_Link2.
     * @return VSuperDoc_DocPermissions_License_Link2
     */
    public ViewLinkImpl getVSuperDoc_DocPermissions_License_Link2() {
        return (ViewLinkImpl)findViewLink("VSuperDoc_DocPermissions_License_Link2");
    }

    /**
     * Container's getter for DocDocumentsView6.
     * @return DocDocumentsView6
     */
    public ViewObjectImpl getDocDocumentsView6() {
        return (ViewObjectImpl)findViewObject("DocDocumentsView6");
    }

    /**
     * Container's getter for VSuperDoc_DocDocuments_License_Link2.
     * @return VSuperDoc_DocDocuments_License_Link2
     */
    public ViewLinkImpl getVSuperDoc_DocDocuments_License_Link2() {
        return (ViewLinkImpl)findViewLink("VSuperDoc_DocDocuments_License_Link2");
    }

    /**
     * Container's getter for DocDocumentsView7.
     * @return DocDocumentsView7
     */
    public DocDocumentsViewImpl getDocDocumentsView7() {
        return (DocDocumentsViewImpl)findViewObject("DocDocumentsView7");
    }

    /**
     * Container's getter for VSuperDoc_DocDocuments_Permission_Link1.
     * @return VSuperDoc_DocDocuments_Permission_Link1
     */
    public ViewLinkImpl getVSuperDoc_DocDocuments_Permission_Link1() {
        return (ViewLinkImpl)findViewLink("VSuperDoc_DocDocuments_Permission_Link1");
    }

    /**
     * Container's getter for DocPermissionsView5.
     * @return DocPermissionsView5
     */
    public DocPermissionsViewImpl getDocPermissionsView5() {
        return (DocPermissionsViewImpl)findViewObject("DocPermissionsView5");
    }

    /**
     * Container's getter for VSupperDoc_DocPermissions_Permission_Link1.
     * @return VSupperDoc_DocPermissions_Permission_Link1
     */
    public ViewLinkImpl getVSupperDoc_DocPermissions_Permission_Link1() {
        return (ViewLinkImpl)findViewLink("VSupperDoc_DocPermissions_Permission_Link1");
    }

    /**
     * Container's getter for DocPermissionsView6.
     * @return DocPermissionsView6
     */
    public DocPermissionsViewImpl getDocPermissionsView6() {
        return (DocPermissionsViewImpl)findViewObject("DocPermissionsView6");
    }

    /**
     * Container's getter for VSupperDoc_DocPermissions_Permission_Link2.
     * @return VSupperDoc_DocPermissions_Permission_Link2
     */
    public ViewLinkImpl getVSupperDoc_DocPermissions_Permission_Link2() {
        return (ViewLinkImpl)findViewLink("VSupperDoc_DocPermissions_Permission_Link2");
    }

    /**
     * Container's getter for DocDocumentsView8.
     * @return DocDocumentsView8
     */
    public DocDocumentsViewImpl getDocDocumentsView8() {
        return (DocDocumentsViewImpl)findViewObject("DocDocumentsView8");
    }

    /**
     * Container's getter for VSuperDoc_DocDocuments_Permission_Link2.
     * @return VSuperDoc_DocDocuments_Permission_Link2
     */
    public ViewLinkImpl getVSuperDoc_DocDocuments_Permission_Link2() {
        return (ViewLinkImpl)findViewLink("VSuperDoc_DocDocuments_Permission_Link2");
    }

    /**
     * Container's getter for DocRequestsView4.
     * @return DocRequestsView4
     */
    public DocRequestsViewImpl getDocRequestsView4() {
        return (DocRequestsViewImpl)findViewObject("DocRequestsView4");
    }

    /**
     * Container's getter for DocDocuments_DocRequests_Link1.
     * @return DocDocuments_DocRequests_Link1
     */
    public ViewLinkImpl getDocDocuments_DocRequests_Link1() {
        return (ViewLinkImpl)findViewLink("DocDocuments_DocRequests_Link1");
    }


    /**
     * Container's getter for RObjObjectCurrentView1.
     * @return RObjObjectCurrentView1
     */
    public ViewObjectImpl getRObjObjectCurrentView1() {
        return (ViewObjectImpl)findViewObject("RObjObjectCurrentView1");
    }

    /**
     * Container's getter for DocDocumentsRelationsView1.
     * @return DocDocumentsRelationsView1
     */
    public DocDocumentsRelationsViewImpl getDocDocumentsRelationsView1() {
        return (DocDocumentsRelationsViewImpl)findViewObject("DocDocumentsRelationsView1");
    }

    /**
     * Container's getter for RGunGunsView1.
     * @return RGunGunsView1
     */
    public ViewObjectImpl getRGunGunsView1() {
        return (ViewObjectImpl)findViewObject("RGunGunsView1");
    }

    /**
     * Container's getter for RGunGunsView2.
     * @return RGunGunsView2
     */
    public ViewObjectImpl getRGunGunsView2() {
        return (ViewObjectImpl)findViewObject("RGunGunsView2");
    }

    /**
     * Container's getter for VSuperDoc_RGunGuns_License_Link1.
     * @return VSuperDoc_RGunGuns_License_Link1
     */
    public ViewLinkImpl getVSuperDoc_RGunGuns_License_Link1() {
        return (ViewLinkImpl)findViewLink("VSuperDoc_RGunGuns_License_Link1");
    }

    /**
     * Container's getter for RGunGunsView3.
     * @return RGunGunsView3
     */
    public ViewObjectImpl getRGunGunsView3() {
        return (ViewObjectImpl)findViewObject("RGunGunsView3");
    }

    /**
     * Container's getter for VSuperDoc_RGunGuns_Permission_Link1.
     * @return VSuperDoc_RGunGuns_Permission_Link1
     */
    public ViewLinkImpl getVSuperDoc_RGunGuns_Permission_Link1() {
        return (ViewLinkImpl)findViewLink("VSuperDoc_RGunGuns_Permission_Link1");
    }

    /**
     * Container's getter for GunGunsView2.
     * @return GunGunsView2
     */
    public ViewObjectImpl getGunGunsView2() {
        return (ViewObjectImpl)findViewObject("GunGunsView2");
    }

    /**
     * Container's getter for RGunGuns_GunGuns_Link1.
     * @return RGunGuns_GunGuns_Link1
     */
    public ViewLinkImpl getRGunGuns_GunGuns_Link1() {
        return (ViewLinkImpl)findViewLink("RGunGuns_GunGuns_Link1");
    }

    /**
     * Container's getter for CodeGunView8.
     * @return CodeGunView8
     */
    public ViewObjectImpl getCodeGunView8() {
        return (ViewObjectImpl)findViewObject("CodeGunView8");
    }

    /**
     * Container's getter for GunGuns_CodeGun_Link1.
     * @return GunGuns_CodeGun_Link1
     */
    public ViewLinkImpl getGunGuns_CodeGun_Link1() {
        return (ViewLinkImpl)findViewLink("GunGuns_CodeGun_Link1");
    }

    /**
     * Container's getter for CodeGunView9.
     * @return CodeGunView9
     */
    public ViewObjectImpl getCodeGunView9() {
        return (ViewObjectImpl)findViewObject("CodeGunView9");
    }

    /**
     * Container's getter for GunGuns_CodeGun_Link2.
     * @return GunGuns_CodeGun_Link2
     */
    public ViewLinkImpl getGunGuns_CodeGun_Link2() {
        return (ViewLinkImpl)findViewLink("GunGuns_CodeGun_Link2");
    }
}
