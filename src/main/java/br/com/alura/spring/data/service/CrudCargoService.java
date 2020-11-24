package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private boolean system= true;
	 private final CargoRepository cargoRepository;
	 
	 public CrudCargoService (CargoRepository cargoRepository){
		 this.cargoRepository = cargoRepository;
	 }
	 
	 public void inicial(Scanner scanner) {
		 while(system) {
			 System.out.println("Qual ação você quer executar?");
				System.out.println("0 - Sair");
				System.out.println("1 - Salvar");
				System.out.println("2 - Atualizar");
				
				int action= scanner.nextInt();
				switch (action) {
				case 1:
					salvar(scanner);
					break;
				case 2:
					atualizar(scanner);

				default:
					system = false;
					break;
				}
		 }
		salvar(scanner);
	 }
	 
	 public void salvar(Scanner scanner) {
		 System.out.println("Descrição do cargo");
		 String descricao = scanner.next();
		 Cargo cargo = new Cargo();
		 cargo.setDescricao(descricao);
		 cargoRepository.save(cargo);
		 System.out.println("Salvo com sucesso.");
	 }
	 
	 private void atualizar(Scanner scanner) {
		 System.out.println("ID");
		 int id= scanner.nextInt();
		 System.out.println("Descrição do cargo");
		 String descricao = scanner.next();
		 Cargo cargo = new Cargo();
		 cargo.setId(id);
		 cargo.setDescricao(descricao);
		 cargoRepository.save(cargo);
		 System.out.println("Atualizado com sucesso.");
	 }
	 
}
