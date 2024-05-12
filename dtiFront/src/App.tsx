import React, { useState } from 'react';
import PetshopForm from './components/PetshopRequestForm';
import MelhorPetshopDisplay from './components/MelhorPetshopDisplay';
import api from './api';

const App: React.FC = () => {
  const [melhorPetshop, setMelhorPetshop] = useState <{ nome: string; precoTotal: number } | null>(null);

    const handleFormSubmit = async(formData: { data: string; quantidadePequenos: number; quantidadeGrandes: number }) => {
    
    const response = await api.get(`/petshop/melhor-petshop?data=${formData.data}&quantidadePequenos=${formData.quantidadePequenos}&quantidadeGrandes=${formData.quantidadeGrandes}`);
    console.log(response.data);

    setMelhorPetshop(response.data);
  };

  return (
    <div className="App">
      <h1 className="title">Busca de Petshop</h1>
      <PetshopForm  onSubmit={handleFormSubmit} />
      {melhorPetshop && <MelhorPetshopDisplay nome={melhorPetshop.nome}precoTotal={melhorPetshop.precoTotal} />}
    </div>
  );
};

export default App;
