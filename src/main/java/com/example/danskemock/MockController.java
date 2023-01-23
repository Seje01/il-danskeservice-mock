package com.example.danskemock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="danskemock", produces = "application/xml")
@Slf4j
public class MockController {
    private static String uploadFile =
            "<?xml version=\"1.0\"?>\n"
                    + "<ApplicationResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n"
                    + "                     xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope\"\n"
                    + "                     xmlns:sig=\"http://danskebank.dk/AGENA/SEPA/SigningService\"\n"
                    + "                     xmlns:dpstate=\"http://danskebank.dk/AGENA/SEPA/dpstate\" xmlns=\"http://bxd.fi/xmldata/\">\n"
                    + "    <CustomerId>7D3447</CustomerId>\n"
                    + "    <Timestamp>2015-02-20T09:42:00.3886102+01:00</Timestamp>\n"
                    + "    <ResponseCode>00</ResponseCode>\n"
                    + "    <ResponseText>OK</ResponseText>\n"
                    + "    <Compressed>true</Compressed>\n"
                    + "    <CompressionMethod>gzip</CompressionMethod>\n"
                    + "</ApplicationResponse>";
    private static String downloadFileList =
            "<?xml version=\"1.0\"?>\n"
                    + "<ApplicationResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n"
                    + "                     xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope\"\n"
                    + "                     xmlns:sig=\"http://danskebank.dk/AGENA/SEPA/SigningService\"\n"
                    + "                     xmlns:dpstate=\"http://danskebank.dk/AGENA/SEPA/dpstate\" xmlns=\"http://bxd.fi/xmldata/\">\n"
                    + "    <CustomerId>7D3447</CustomerId>\n"
                    + "    <Timestamp>2015-02-20T09:42:00.3886102+01:00</Timestamp>\n"
                    + "        <ResponseCode>00</ResponseCode>\n"
                    + "        <ResponseText>OK</ResponseText>\n"
                    + "        <FileDescriptors>\n"
                    + "                <FileDescriptor>\n"
                    + "                    <FileReference>1511090010-1511092000</FileReference>\n"
                    + "                    <TargetId>20151109</TargetId>\n"
                    + "                    <ServiceId>0050171693</ServiceId>\n"
                    + "                    <UserFilename>BGMAXWS13630071821</UserFilename>\n"
                    + "                    <FileType>BG_MAX</FileType>\n"
                    + "                    <FileTimestamp>2015-11-09T20:00:00</FileTimestamp>\n"
                    + "                    <Status>NEW</Status>\n"
                    + "                    <SubType>KRE</SubType>\n"
                    + "                </FileDescriptor>\n"
                    + "                <FileDescriptor>\n"
                    + "                    <FileReference>1511090010-1511092003</FileReference>\n"
                    + "                    <TargetId>20151109</TargetId>\n"
                    + "                    <ServiceId>0050171690</ServiceId>\n"
                    + "                    <UserFilename>BGMAXWS13630071821</UserFilename>\n"
                    + "                    <FileType>BG_MAX</FileType>\n"
                    + "                    <FileTimestamp>2015-11-09T20:00:00</FileTimestamp>\n"
                    + "                    <Status>NEW</Status>\n"
                    + "                    <SubType>KRE</SubType>\n"
                    + "                </FileDescriptor>\n"
                    + "        </FileDescriptors>\n"
                    + "</ApplicationResponse>";

    private static String downloadFile =
            "<?xml version=\"1.0\"?>\n"
                    + "<ApplicationResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n"
                    + "                     xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope\"\n"
                    + "                     xmlns:sig=\"http://danskebank.dk/AGENA/SEPA/SigningService\"\n"
                    + "                     xmlns:dpstate=\"http://danskebank.dk/AGENA/SEPA/dpstate\" xmlns=\"http://bxd.fi/xmldata/\">\n"
                    + "    <CustomerId>7D3447</CustomerId>\n"
                    + "    <Timestamp>2015-02-20T09:42:00.3886102+01:00</Timestamp>\n"
                    + "    <ResponseCode>00</ResponseCode>\n"
                    + "    <ResponseText>OK</ResponseText>\n"
                    + "    <Content>MTUxMTA5MDAxMC0xNTExMDkyMDAw</Content>\n"
                    + "</ApplicationResponse>";

    @PostMapping
    public ResponseEntity mockPost(@RequestBody ApplicationRequest request) {
        log.info(">>>>>>>>>>>>>>>>>>" + request);
        String command = request.getCommand();

        if (command.equals("DownloadFileList")) {
            return getStringResponseEntity(downloadFileList);
        }

        if (command.equals("UploadFile")) {
            return getStringResponseEntity(uploadFile);
        }

        if (command.equals("DownloadFile")) {
            return getStringResponseEntity(downloadFile);
        }
        return new ResponseEntity<>(">>>>>>>>>>>>>>>>>>>>>" + command,HttpStatus.BAD_REQUEST);
    }

    private static ResponseEntity<String> getStringResponseEntity(String downloadFileList) {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<String> entityModel
                = new ResponseEntity<>(downloadFileList, headers,
                HttpStatus.CREATED);
        return entityModel;
    }
}
