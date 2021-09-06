package br.com.setebit.deliveryservice.util;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Component
public class RelatorioUtil {

	public RelatorioUtil() {
	}

	public JasperPrint gerarPdf(List<?> dados, String nomeRelatorio) throws JRException, SQLException {
		// Pega o arquivo .jasper localizado em resources
		InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/" + nomeRelatorio);
		// Cria o objeto JaperReport com o Stream do arquivo jasper
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,
				new JRBeanCollectionDataSource(dados));

		return jasperPrint;
	}

}