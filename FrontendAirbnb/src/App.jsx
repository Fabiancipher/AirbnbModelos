import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { AppProvider } from './context/AppContext'
import Navbar from './components/Navbar/Navbar'
import Home from './pages/Home/Home'
import Detalles from './pages/Detalles/Detalles'
import Checkout from './pages/Checkout/Checkout'
import Perfil from './pages/Perfil/Perfil'
import Anfitrion from './pages/Anfitrion/Anfitrion'
import Chat from './pages/Chat/Chat'

export default function App() {
  return (
    <AppProvider>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/detalles/:id" element={<Detalles />} />
          <Route path="/checkout/:id" element={<Checkout />} />
          <Route path="/perfil" element={<Perfil />} />
          <Route path="/anfitrion" element={<Anfitrion />} />
          <Route path="/chat" element={<Chat />} />
        </Routes>
      </BrowserRouter>
    </AppProvider>
  )
}