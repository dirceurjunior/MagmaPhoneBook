/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magmaphonebook.mb;

import com.magmaphonebook.model.backupRestore.BackupRestore;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Dirceu Junior
 */
@ManagedBean
@ViewScoped
public class BackupRestoreMB implements Serializable {

   private static final long serialVersionUID = 1L;

   public void realizarBackup() throws IOException, InterruptedException, ParseException {
      BackupRestore br = new BackupRestore();
      br.realizaBackup();
   }

   public void realizarBackupSQL() throws IOException, InterruptedException {
      BackupRestore br = new BackupRestore();
      br.realizarBackupSQL();
   }

   public void realizaRestore() throws IOException, InterruptedException {
      BackupRestore br = new BackupRestore();
      br.realizaRestore();
   }

}
