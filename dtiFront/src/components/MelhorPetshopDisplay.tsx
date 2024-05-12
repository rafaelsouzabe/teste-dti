import React from 'react';

interface MelhorPetshopProps {
  nome: string;
  precoTotal: number;
}

// interface Props {
//   melhorPetshop: MelhorPetshopResponse | null;
// }

const MelhorPetshopDisplay: React.FC<MelhorPetshopProps> = ({nome, precoTotal}) => {

  return (
    <div className='MelhorPetshopDisplay'>
      <h2>Melhor Petshop:</h2>
      <p>Nome: {nome}</p>
      <p>Preço Total: R${precoTotal.toFixed(2)}</p>
    </div>
  );
};

export default MelhorPetshopDisplay;