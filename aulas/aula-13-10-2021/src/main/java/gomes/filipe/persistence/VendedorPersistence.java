package gomes.filipe.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import gomes.filipe.entity.Vendedor;
import gomes.filipe.exception.PersistenceException;

@Repository
public class VendedorPersistence {

	private File arquivo;

	public VendedorPersistence(File arquivo) {
		super();
		this.arquivo = arquivo;
	}

	public VendedorPersistence() {

	}

	public Vendedor cadastro(Vendedor vendedor, boolean manter) throws IOException{
		String registro = vendedor.getCodigo() + ";" + vendedor.getCpf() + vendedor.getNome() + ";" + vendedor.getCidade() + ";" + vendedor.getUf();

		try(FileOutputStream fos = new FileOutputStream(arquivo, manter);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				BufferedWriter bw = new BufferedWriter(osw)
				) {

			bw.append(registro);
			bw.newLine();
		}
		return vendedor;
	}

	public void cadastro(List<Vendedor> vendedores) throws IOException {
		try(FileOutputStream fos = new FileOutputStream(arquivo);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				BufferedWriter bw = new BufferedWriter(osw)
				) {

			bw.write("");
		}

		try(FileOutputStream fos = new FileOutputStream(arquivo);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				BufferedWriter bw = new BufferedWriter(osw);
				) {

			for (Vendedor vendedor : vendedores) {
				String registro = vendedor.getCodigo() + ";" + vendedor.getCpf() + vendedor.getNome() + ";" + vendedor.getCidade() + ";" + vendedor.getUf();
				bw.append(registro);
				bw.newLine();
			}
		}
	}


	private Vendedor converte(String registro) {
		String[] campos = registro.split(";");
		return new Vendedor(campos[0],campos[1], campos[2], campos[3]);
	}

	private List<String> retornaRegistros() {
		List<String> registros = new ArrayList<>();

		try(FileInputStream fos = new FileInputStream(arquivo);
				InputStreamReader isr = new InputStreamReader(fos);
				BufferedReader br = new BufferedReader(isr)
				) {
			registros = new ArrayList<>();
			while(true) {
				String linha = br.readLine();
				if (linha == null) {
					break;
				}
				registros.add(linha);
			}
		} catch (FileNotFoundException e) {
			throw new PersistenceException("Arquivo não foi localizado");
		} catch (IOException e) {
			throw new PersistenceException("Erro ao retornar os registros"); 
		}
		return registros;
	}

	public List<Vendedor> listagem() {
		List<Vendedor> vendedoresExistentes = new ArrayList<>();

		List<String> registros = retornaRegistros();
		registros.forEach(registro -> {
			Vendedor vendedor = converte(registro);
			vendedoresExistentes.add(vendedor);
		});
		return vendedoresExistentes;

	}
}
