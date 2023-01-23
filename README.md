# il-danskeservice-mock

create to test il-danske-service locally

# changes in application.yml
file-prefix: P # DISABLED
danske:
  send-to: http://localhost:8081/danskemock
    # upload-files: [ ]
  upload-files:
    - file-name-pattern: utbetalning\\${file-prefix}_LP_P1__(.+)\.xml
      file-type: pain.001.001.03
    - file-name-pattern: utbetalning\\${file-prefix}_OP_KI_Lon_31_(.+)\.txt
      file-type:
    - file-name-pattern: utbetalning\\${file-prefix}_OP_LB_(Konto|PG|AviBG)_(31|32|33)_(.+)\.txt
      file-type:
    - file-name-pattern: utbetalning\\${file-prefix}_OP_P1_(SEPA|IBAN|UKonto|SClear|UCheck|TEST|AVI|PG)_ADM_(31|32|33)_(.+)\.xml
      file-type: pain.001.001.03
    - file-name-pattern: ag\\BFEP\.I.*\.txt
      file-type:
	  
inca:
  file-root: C:\ROOT\IL
