// *** WARNING: DO NOT MODIFY *** This is a generated Java source code! 
// 
// Generated by LF-ET 2.1.5 (210417a), https://www.lohrfink.de/lfet
// From decision table
// "/opt/data/github/lfet-show-case/src/main/resources/lfet/LFETShowCase.lfet"
// 14.06.2021 09:16
// 
// Prolog Standard ---->
// profile LFET.Java.Prolog.Standard.Interface.ini not found
// used LF-ET 2.1.5 (210417a) build in default

package de.lfet.demo.application;

import javax.annotation.processing.Generated;

@Generated("LFET")
interface LFETShowCase_Iface<T>
{
 
    // Prolog Standard <----
    
    /** 
     * <b>B02: Alter ?</b><br>
     * <br>
     * The parm generation has been triggered in project.ini by:<br>
     * - ide.Java.InterfaceParm.1: Symbol ; Title=Interval ; ; IncludeTags = Alter
     */
    boolean __isAlter(String symbol, String title, double titleMin, double titleMax, T model);
    
    /** 
     * <b>B03: Abgeschlossener Tarif ?</b><br>
     * <br>
     * The parm generation has been triggered in project.ini by:<br>
     * - ide.Java.InterfaceParm.10: Symbol ; Title ; Text ; IncludeTags = Meldung, Tarif
     */
    boolean __isAbgeschlossenerTarif(String symbol, String title, String text, T model);
    
    /** 
     * <b>A01: Meldung</b><br>
     * <br>
     * The parm generation has been triggered in project.ini by:<br>
     * - ide.Java.InterfaceParm.10: Symbol ; Title ; Text ; IncludeTags = Meldung, Tarif
     */
    void __doMeldung(String symbol, String title, String text, T model);
    
    void __doTrace(java.lang.String dtName, java.lang.String version, int rules, int rule, T model);

    // Epilog Standard ---->
    // profile LFET.Java.Epilog.Standard.Interface.ini not found
    // used LF-ET 2.1.5 (210417a) build in default

}
 
// Epilog Standard <----

// End of generated Java source code
// Generated by LF-ET 2.1.5 (210417a), https://www.lohrfink.de/lfet

