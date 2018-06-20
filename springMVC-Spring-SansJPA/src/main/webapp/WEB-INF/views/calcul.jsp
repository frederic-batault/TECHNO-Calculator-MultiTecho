<div class="calcul">
	<form method="post" action="calc">
		
			<label for="nb1">nombre 1:</label> <input id="nb1" name="nombre1"
				class="form-control" />
		
		
			<label>operation : <select id="ope" name="operateur">
					<option value="1">+</option>
					<option value="2">-</option>
					<option value="3">*</option>
					<option value="4">/</option>
			</select>
			</label>
		
		
			<label for="nb1">nombre 2:</label> <input id="nb2" name="nombre2"
				class="form-control" />
		
		<button>=</button>
		<label for="res">resultat :</label> <p id="res">${calculDomaine.resultatTexte}</p>
	</form>
		
	
</div>