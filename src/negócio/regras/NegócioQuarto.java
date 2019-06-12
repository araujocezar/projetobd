package negócio.regras;
import dados.RepositorioQuarto;
import dados.IRepositorioQuarto;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entidade.quarto.Quarto;
import exceção.*;
import java.io.FileOutputStream;
import java.io.IOException;

//Regras de negócio de quarto, trabalha de maneira simples, fazendo apenas as chamadas da camada de dados.
public class NegócioQuarto {

    private IRepositorioQuarto repQuarto;
	
    public NegócioQuarto(IRepositorioQuarto repQuarto){
	this.repQuarto = repQuarto;
    }

    public boolean existeQuarto(Quarto quarto){
        return repQuarto.existeQuarto(quarto);
    }
	
    public Quarto buscarQuarto(String numeroQuarto){
	return repQuarto.buscarQuarto(numeroQuarto);
    }
	
    public void adicionarQuarto(Quarto quarto) throws QuartoExistenteException{
	boolean x = repQuarto.existeQuarto(quarto);
	if(x){
            throw new QuartoExistenteException();
	}
	else{
            repQuarto.adicionarQuarto(quarto);
	}
    }
	
    public void removerQuarto(Quarto quarto) throws QuartoInexistenteException{
	boolean x = this.existeQuarto(quarto);
	if(!x){
            throw new QuartoInexistenteException();
	}
	else{
            repQuarto.removerQuarto(quarto);
	}
    }
	
    public void atualizarQuarto(Quarto q, boolean isPremium) throws QuartoInexistenteException, QuartoExistenteException{
        repQuarto.atualizarQuarto(q, isPremium);
    }
    
      
    /*
    Retorna as informações do quarto, como hóspede responsável e valores de diária e consumação apenas pra informação ao
    ser realizado o check-out.
    
    public String infoCheckOut(Quarto quarto) throws QuartoInexistenteException{
        if(quarto == null){
            throw new QuartoInexistenteException();
        }
        else{
            return repQuarto.infoCheckOut(quarto);
        }
    }
    
    /*
    Recebe o quarto a ser realizado o check-out e desfaz as alterações que o check-in faz. Hóspede vira nulo novamente, a
    flag passa a ser desocupado, a consumação é zerada e o débito do hóspede.
    */
    public void checkOut(Quarto quarto) throws QuartoInexistenteException{
	if(quarto == null){
            throw new QuartoInexistenteException();
	}
	else{
            quarto.desocupar();
            quarto.zerarConsumo();
            quarto.getHospede().zerarDebito();
            quarto.setHospede(null);
	}
    }
    
   /*
    Trabalha com a biblioteca externa iText, e gera uma espécie de boleto para o hóspede quando se realiza o check-out.
    É chamado internamente ao realizar-se o check-out e o pdf é criado dentro da pasta do projeto.
    */
    
    /*
    public void gerarPDF(Quarto quarto) throws QuartoInexistenteException{
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Boleto.pdf"));
            document.open();
            document.setPageSize(PageSize.A3);
            Image figura = Image.getInstance("Imagem2.png");
            document.add(figura);
            document.add(new Paragraph("\n\n\n\n"));   
            document.add(new Paragraph("      Hóspede Responsável: " + quarto.getHospede().getNome() + "\n\n"));
            document.add(new Paragraph("      Consumo do quarto: R$" + quarto.getConsumação() + "\n\n"));
            document.add(new Paragraph("      Valor Diárias: R$" + quarto.getHospede().getDebito() + "\n\n"));
            document.add(new Paragraph("\n\n\n\n"));  
            document.add(new Paragraph("      Valor total = R$" + (quarto.getConsumação() + quarto.getHospede().getDebito())));
            document.add(new Paragraph("\n\n\n\n"));
            Image codBarras = Image.getInstance("CodBarras.jpeg");
            document.add(codBarras);
        }
        catch(DocumentException | IOException de) {
            System.out.println(de.getMessage());
        }
        document.close();
    }*/ 
}
